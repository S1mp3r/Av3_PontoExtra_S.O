import java.util.*;
// Caso o import de utils dê problema por conta de uma aplicação antiga, descomente essas linhas abaixo e comente a de cima.
// Descomentar linha 4 e 5.
// Comentar linha 1.
// import java.util.ArrayList;
// import java.util.List;

public class Directory {
    private String name;
    private List<File> files;
    private List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        subDirectories.add(directory);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    public void removeDirectory(Directory directory) {
        subDirectories.remove(directory);
    }

    public File getFileByName(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }

    public Directory getDirectoryByName(String name) {
        for (Directory dir : subDirectories) {
            if (dir.getName().equals(name)) {
                return dir;
            }
        }
        return null;
    }
}