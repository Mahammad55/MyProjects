package az.orient.dictionary.method;

import java.io.*;

public class Login {
    public static void writeLoginToFile(String username, String password,String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(username + " " + password);
        }
    }

    public static boolean loginRequest(String username, String password, String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String data;
        while ((data = br.readLine()) != null) {
            String[] dataParse = data.split(" ");
            String usernameInFile = dataParse[0];
            String passwordInFile = dataParse[1];
            if (username.equals(usernameInFile) && password.equals(passwordInFile)) {
                return true;
            }
        }
        return false;
    }
    public static void register(String username,String password,String filePath) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filePath));
        String data;
        boolean isHave=true;
        while ((data= br.readLine())!=null){
            String [] dataParse=data.split(" ");
            String usernameInFile=dataParse[0];
            if(username.equals(usernameInFile) ){
                System.out.println("This admin is now available\n");
                isHave=false;
                break;
            }
        }
        if(isHave){
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath,true))) {
                bw.write(username+" "+password);
                bw.newLine();
            }
            System.out.println("Register successfully\n");
        }
    }
}

