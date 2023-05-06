package az.orient.examscores.model;

import java.io.*;
import java.nio.Buffer;

public class Dean {
    private static final String Dean_Folder_Path = "D:\\Java\\Dean";
    private static final String Dean_Login_Path = "D:\\Java\\Dean\\dean.txt";

    public static void writeToFile(String username, String password) throws Exception {
        File file = new File(Dean_Folder_Path);
        if (!file.exists()) {
            file.mkdir();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Dean_Login_Path, true))) {
            bufferedWriter.write(username + " " + password);
            bufferedWriter.newLine();
        }
    }

    public static boolean deanLogin(String username, String password) throws Exception {
        FileReader fileReader = new FileReader(Dean_Login_Path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(" ");
            String usernameInFile = data[0];
            String passwordInFile = data[1];
            if (username.equals(usernameInFile) && password.equals(passwordInFile)) {
                return true;
            }
        }
        return false;
    }

    public static void register(String username, String password) throws Exception {
        FileReader fileReader = new FileReader(LabAssistant.Lab_Login_Path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        boolean isFlag = true;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(" ");
            String usernameInFile = data[0];
            String passwordInFile = data[1];
            if (username.equals(usernameInFile) && password.equals(passwordInFile)) {
                System.out.println("This Assistant is now available\n");
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LabAssistant.Lab_Login_Path, true))) {
                bufferedWriter.write(username + " " + password);
                bufferedWriter.newLine();
            }
            System.out.println("Register Successful");
        }
    }
}