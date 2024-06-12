public class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        this.root = new Directory("root:");
        this.journal = new Journal();
    }

    public void createFile(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            if (dir.containFile(name)) {
                System.out.println("Erro! Arquivo com nome Dúplicado!");
            }
            if(!dir.containsDirectory(name)) {
                File file = new File(name);
                dir.addFile(file);
                journal.addEntry("Created file: " + name + " at " + path);
            }
        }
        if(dir == null)
            System.out.println("Erro! Diretorio inexistente!");
    }

    public void createDirectory(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            if (dir.containsDirectory(name)) {
                System.out.println("Erro! Diretorio ja existe!");
            }
            if(!dir.containsDirectory(name)) {
                Directory newDir = new Directory(name);
                dir.addDirectory(newDir);
                journal.addEntry("Created directory: " + name + " at " + root);
            }
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
            if (file == null) {
                System.out.println("Erro! Arquivo inexistente!");
            }
        }
        if(dir == null)
        System.out.println("Erro! Diretorio inexistente!");
    }

    public void deleteDirectory(String path, String name) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getDirectoryByName(name);
            if (subDir != null) {
                dir.removeDirectory(subDir);
                journal.addEntry("Deleted directory: " + name + " from " + path);
            } else {
                System.out.println("Erro! Diretorio inexistente!");
            }
        }
        if(dir == null)
            System.out.println("Erro! Diretorio não existente!");
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = dir.getFileByName(oldName);
            if (file != null) {
                file.setName(newName);
                journal.addEntry("Renamed file: " + oldName + " to " + newName + " at " + path);
            } else {
                System.out.println("Erro! Arquivo inexistente!");
            }
        }
        if(dir == null)
            System.out.println("Erro! Diretorio não existente!");
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getDirectoryByName(oldName);
            if (subDir != null) {
                subDir.setName(newName);
                journal.addEntry("Renamed directory: " + oldName + " to " + newName + " at " + path);
            } else {
                System.out.println("Erro! Diretorio inexistente!");
            }
        }
        if(dir == null)
            System.out.println("Erro! Diretorio inexistente");
    }

    public void copyFile(String path, String newPath, String fileName) {
        Directory dir = navigateToDirectory(path);
        Directory newDir = navigateToDirectory(newPath);
        if (dir != null && newDir != null) {
            if (dir == newDir) {
                if(dir.containFile(fileName)) {
                    if(dir.getFileByName(fileName).getQtt() == 0) {
                        dir.addFile(dir.getFileByNameSpecialCase(fileName));
                    } else {
                        dir.addFile(dir.getFileByNameSpecialCaseDuplicated(fileName));
                    }
                    dir.getFileByName(fileName).incrementalQtt();
                    journal.addEntry("Coping file: " + fileName + " at " + path);
                } else {
                    System.out.println("Erro! Arquivo inexistente!");
               }
            }
            if(dir != newDir){
                if(dir.containFile(fileName)) {
                    if(dir.getFileByName(fileName).getQtt() == 0) {
                        newDir.addFile(dir.getFileByNameSpecialCase(fileName));
                    } else {
                        newDir.addFile(dir.getFileByNameSpecialCaseDuplicated(fileName));
                    }
                    dir.getFileByName(fileName).incrementalQtt();
                    journal.addEntry("Coping file: " + fileName + " at " + newPath);
                }
            }
        }
        if (dir == null || newDir == null) 
            System.out.println("Erro! Diretorio inexistente");
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
        if (dir == null)
            System.out.println("Erro! Arquivo inexistente!");
    }

    public void listDirectory(String path) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            System.out.println("Listing directories: " + path);
            for (Directory subDir : dir.getSubDirectories()) {
                System.out.println("Directory: " + subDir.getName());
            }
        }
        if (dir == null)
            System.out.println("Erro! Diretorio inexistente!");
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
