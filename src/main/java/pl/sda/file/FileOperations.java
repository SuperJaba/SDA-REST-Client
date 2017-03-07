package pl.sda.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class FileOperations {
    public static void main(String[] args) throws IOException {
        String message = "Hello World";
        File file = new File("C:\\Users\\RENT\\Desktop\\test.txt");
//        exampleWriteToFile(message, file);
//        exampleReadFromFile(file);
//        zadanko(file);// ciekawostka, ale nie wyszla
//        readNamesInOneLine(file);
//        readLinesFromFile(file);
//        readFromFileAddToList(file);
        List <User> users = readUsersFromFile(file);
        users.forEach(e-> System.out.println(e));
        System.out.println();
        User user = new User();
        user.setFirstName("Janusz");
        user.setLastName("Smierdzianusz");
        user.setAge(35);
        addUserToFile(user, file);

        users = readUsersFromFile(file);
        users.forEach(e-> System.out.println(e));



    }

    public static void addUserToFile(User user, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user);
        }
    }

    private static void readFromFileAddToList(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String kolejnaLinia = scanner.nextLine();
                System.out.println(kolejnaLinia);
            }
        }

    }

    private static List<User> readUsersFromFile(File file) throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                //1. czytamy linie z pliku
                String kolejnaLinia = scanner.nextLine();
                String[] split = kolejnaLinia.split(" ");
                //2. tworzymy nowy obiekt
                User user = new User();
                user.setFirstName(split[0]);
                user.setLastName(split[1]);
                user.setAge(new Integer(split[2]));
                //3. dodajemy do listy
                userList.add(user);
//             System.out.println(scanner.nextLine());
            }
        }
        return userList;
    }

    private static void readNamesInOneLine(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String nextLine = scanner.nextLine();
            String[] split = nextLine.split(" ");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }
        }
    }


    private static void zadanko(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String[] imiona = scanner.toString().split(" ");
            for (int i = 0; i < imiona.length; i++) {
                System.out.println(imiona[i]);
            }
        }
    }

    private static void exampleReadFromFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }


    public static void exampleWriteToFile(String message, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        }
    }
}

