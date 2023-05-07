package az.orient.dictionary.method;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static void writeWordToDictionary(String firstWord, String secondWord, String filePath) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(firstWord + " - " + secondWord);
            br.newLine();
        }
    }

    public static int check(String filePath, String dictionaryPath) {
        int response = 2;
        String[] dataFile = filePath.split("[_.]+");
        try {
            boolean isFlag = false;  // 1 - success 2 - dictionary doesn't exist  3 - error
            BufferedReader br = new BufferedReader(new FileReader(dictionaryPath));
            String data;
            while ((data = br.readLine()) != null) {
                String[] dataParse = data.split("-");
                if (dataParse[0].trim().equalsIgnoreCase(dataFile[0]) && dataParse[1].trim().equalsIgnoreCase(dataFile[1])) {
                    isFlag = true;
                    break;
                }
            }
            if (isFlag) {
                response = 1;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            response = 3;
        }
        return response;
    }


    public static String translate(String word, String filePath, int dicType) throws IOException {
        String result = "";
        Map<String, String> mapDictionary = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String data;
        while ((data = br.readLine()) != null) {
            String[] dataParse = data.split("-");
            switch (dicType) {
                case 1:
                    result = mapDictionary.put(dataParse[0].trim(), dataParse[1].trim());
                    break;
                case 2:
                    result = mapDictionary.put(dataParse[1].trim(), dataParse[0].trim());
                    break;
                default:
                    System.out.println("Invalid Dictionary type");
            }
        }
        if (mapDictionary.containsKey(word)) {
            result = "" + mapDictionary.get(word);
        } else {
            System.out.println("Not Found");
        }
        return result;

    }

    public static void removeWordFromDic(String word, String filePath) throws IOException {
        Map<String, String> mapDictionary = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String data;
        while ((data = br.readLine()) != null) {

            String[] dataParse = data.split("-");
            mapDictionary.put(dataParse[0].trim(), dataParse[1].trim());
        }
        if (mapDictionary.containsKey(word)) {
            mapDictionary.remove(word);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Map.Entry<String, String> entry : mapDictionary.entrySet()) {
                    bw.write(entry.getKey() + " - " + entry.getValue());
                    bw.newLine();
                }
            }
            System.out.println("The word has been successfully removed from the dictionary\n");
        } else {
            System.out.println("The word was not fount in the file");
        }

    }

    public static void changeWordInDic(String currentWord, String changeWord, String filePath) throws IOException {
        Map<String, String> mapDictionary = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String data;
        while ((data = br.readLine()) != null) {
            String[] dataParse = data.split("-");
            mapDictionary.put(dataParse[0].trim(), dataParse[1].trim());
        }
        if (mapDictionary.containsKey(currentWord)) {
            mapDictionary.replace(currentWord, changeWord);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Map.Entry<String, String> entry : mapDictionary.entrySet()) {
                    bw.write(entry.getKey() + " - " + entry.getValue());
                    bw.newLine();
                }
            }
            System.out.println("The word has been successfully changed in the dictionary\n");
        } else {
            System.out.println("The word was not found in file!!!\n");
        }
    }

    public static void writeLang(String fromLanguage, String toLanguage, String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String data;
        boolean isHave = true;
        while ((data = br.readLine()) != null) {
            String[] dataParse = data.split("-");
            String fromLanguageInFile = dataParse[0].trim();
            String toLanguageInFile = dataParse[1].trim();
            if (fromLanguage.equals(fromLanguageInFile) && toLanguage.equals(toLanguageInFile)) {
                System.out.println("This dictionary is now available\n");
                isHave = false;
                break;
            }
        }
        if (isHave) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                bw.write(fromLanguage + " - " + toLanguage);
                bw.newLine();
            }
            System.out.println();
            System.out.println("The dictionary added successfully\n");
        }
    }

    public static List<String> showCurrentInformation(String filePath) throws IOException {
        List<String> listDictionary = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while (br.ready()) {
            String data = br.readLine();
            listDictionary.add(data);
        }
        return listDictionary;
    }

    public static void createNewDictionary(String filePath) throws IOException {
        new FileWriter(filePath );
    }
}
