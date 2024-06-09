public class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        this.root = new Directory("root");
        this.journal = new Journal();
    }

    public void createFile(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = new File(name);
            dir.addFile(file);
            journal.addEntry("Created file: " + name + " at " + path);
        }
    }

    public void createDirectory(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            Directory newDir = new Directory(name);
            dir.addDirectory(newDir);
            journal.addEntry("Created directory: " + name + " at " + path);
        }
    }

    public void deleteFile(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = dir.getFileByName(name);
            if (file != null) {
                dir.removeFile(file);
                journal.addEntry("Deleted file: " + name + " from " + path);
            }
        }
    }

    public void deleteDirectory(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getDirectoryByName(name);
            if (subDir != null) {
                dir.removeDirectory(subDir);
                journal.addEntry("Deleted directory: " + name + " from " + path);
            }
        }
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = dir.getFileByName(oldName);
            if (file != null) {
                file.setName(newName);
                journal.addEntry("Renamed file: " + oldName + " to " + newName + " at " + path);
            }
        }
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getDirectoryByName(oldName);
            if (subDir != null) {
                subDir.setName(newName);
                journal.addEntry("Renamed directory: " + oldName + " to " + newName + " at " + path);
            }
        }
    }

    public void listDirectoryContents(String path) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            System.out.println("Listing contents of directory: " + path);
            for (File file : dir.getFiles()) {
                System.out.println("File: " + file.getName());
            }
            for (Directory subDir : dir.getSubDirectories()) {
                System.out.println("Directory: " + subDir.getName());
            }
        }
    }

    public void copyFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            dir.addFile(dir.getFileByName(fileName));
            journal.addEntry("Coping file: " + fileName + " at " + path);
        }
    }

    public void acessJournal() {
        journal.getLogSeparate();
    }

    private Directory navigateToDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            current = current.getDirectoryByName(part);
            if (current == null) return null;
        }
        return current;
    }
}
