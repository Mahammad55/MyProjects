package az.orient.examscores.model;

import java.io.*;

public class LabAssistant  {
    public static final String Lab_Folder_Path ="D:\\Java\\LabAssistant";
    public static final String Lab_Login_Path="D:\\Java\\LabAssistant\\labAssistant.txt";
    public static void writeToFile(String username, String password) throws Exception{
        File file=new File(Lab_Folder_Path);
        if(!file.exists()){
            file.mkdir();
        }
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(Lab_Login_Path,true))) {
            bufferedWriter.write(username+" "+password);
            bufferedWriter.newLine();
        }
    }

    public static boolean labAssistantLogin(String username,String password) throws Exception{
        FileReader fileReader=new FileReader(Lab_Login_Path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            String [] data=line.split(" ");
            String usernameInFile=data[0];
            String passwordInFile=data[1];
            if(username.equals(usernameInFile) && password.equals(passwordInFile)){
                return true;
            }
        }
        return false;
    }
}
