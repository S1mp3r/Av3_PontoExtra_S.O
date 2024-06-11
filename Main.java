import java.util.*;
// Caso o import de utils dê problema por conta de uma aplicação antiga, descomente a linha abaixo e comente a linha a cima.
// Descomentar linha 5.
// Comentar linha 1.
// import java.util.Scanner;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();

        Scanner input = new Scanner(System.in);
        Boolean leave = false;
        String path;
        String name;
        String newName;

        while(leave == false) {
            System.out.println("================================================================================");
            System.out.println("1) Criar um Diretorio.");
            System.out.println();
            System.out.println("2) Apagar um Diretorio.");
            System.out.println();
            System.out.println("3) Renomear um Diretorio.");
            System.out.println();
            System.out.println("4) Listar todos os Diretorios presentes.");
            System.out.println();
            System.out.println("5) Criar um arquivo.");
            System.out.println();
            System.out.println("6) Copiar um arquivo.");
            System.out.println();
            System.out.println("7) Apagar um arquivo.");
            System.out.println();
            System.out.println("8) Renomear um arquivo.");
            System.out.println();
            System.out.println("9) Listar arquivos de um Diretorio.");
            System.out.println();
            System.out.println("0) Sair");
            System.out.println();
            System.out.println("Para acessar o log de eventos, digite 'log'...");
            System.out.println();

            String choice = input.nextLine();

            System.out.println();

            switch (choice) {
                case "1":
                    System.out.print("Digite o nome do diretorio: ");
                    name = input.nextLine();
                    System.out.println();
                    fs.createDirectory("/", name);
                    break;
                case "2":
                    System.out.print("Digite o nome do diretorio: ");
                    name = input.nextLine();
                    System.out.println();
                    fs.deleteDirectory("/", name);
                    break;
                case "3":
                    System.out.print("Digite o nome do diretorio: ");
                    name = input.nextLine();
                    System.out.print("Digite o novo nome do diretorio: ");
                    newName = input.nextLine();
                    System.out.println();
                    fs.renameDirectory("/", name, newName);
                    break;
                case "4":
                    fs.listDirectory("/");
                    System.out.println();
                    System.out.print("Aperte qualquer tecla para continuar...");
                    input.nextLine();
                    break;
                case "5":
                    System.out.print("Digite o caminho do arquivo: ");
                    path = input.nextLine();
                    System.out.print("Digite o nome do arquivo: ");
                    name = input.nextLine();
                    System.out.println();
                    fs.createFile("/" + path, name);
                    break;
                case "6":
                    System.out.print("Digite o caminho do arquivo: ");
                    path = input.nextLine();
                    System.out.print("Digite o nome do arquivo: ");
                    name = input.nextLine();
                    System.out.println();
                    fs.copyFile("/" + path, name);
                    break;
                case "7":
                    System.out.print("Digite o caminho do arquivo: ");
                    path = input.nextLine();
                    System.out.print("Digite o nome do arquivo: ");
                    name = input.nextLine();
                    System.out.println();
                    fs.deleteFile("/" + path, name);
                    break;
                case "8":
                    System.out.print("Digite o caminho do arquivo: ");
                    path = input.nextLine();
                    System.out.print("Digite o nome do arquivo: ");
                    name = input.nextLine();
                    System.out.print("Digite o novo nome do arquivo: ");
                    newName = input.nextLine();
                    System.out.println();
                    fs.renameFile("/" + path, name, newName);
                    break;
                case "9":
                    System.out.print("Digite o caminho do diretorio: ");
                    path = input.nextLine();
                    fs.listDirectoryContents(path);
                    System.out.println();
                    System.out.print("Aperte qualquer tecla para continuar...");
                    input.nextLine();
                    break;
                case "0":
                    System.out.println("Obrigado por usar nossa aplicacao!");
                    leave = true;
                    break;
                case "log":
                    fs.acessJournal();
                    System.out.println();
                    System.out.print("Aperte qualquer tecla para continuar...");
                    input.nextLine();
                    break;
            }
        }
    }
}
