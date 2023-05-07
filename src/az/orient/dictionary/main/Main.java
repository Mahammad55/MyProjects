package az.orient.dictionary.main;

import az.orient.dictionary.method.ExtraMethod;
import az.orient.dictionary.method.Login;
import az.orient.dictionary.method.Dictionary;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
     * Bir neçə dildən ibarət lüğət yaratmaq tələb olunur. Lüğət iki hissədən ibarət olacaq.(admin və istifadəçi)
     * Adminin hüquqları:
     * Dinamik olaraq:::::
     * Lugete istifadeci adi ve shifre ile qoshulmaq,
     * Yeni lüğət yaratmaq,
     * Lüğətə yeni söz əlavə etmək,
     * Lüğətdən sözü silmək,
     * Lüğətdə sözü dəyişmək,
     * Luqetleri gormek,
     * Yeni admin qeydiyyatdan kecirmek
     * İstifadəçinin hüquqları:
     * Sistemdə olan cari lüğətləri görmək,
     * Sİstemdə olan lüğətlərə görə bir istiqamətdə və əks istiqamətdə söz axtarmaq. Yəni ki,
     * (Məsələn: rus ingilis , əksi olaraq ingilis rus sözlərinə görə söz axtarmaq).
     */
    public static int chanceForAdmin = 3;
    public static final String ADMIN_LOGIN_PATH = "admin_login.txt";
    public static final String ALL_DICTIONARY_NAMES_PATH = "all_dictionaries.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        String username, password, fromLanguage, toLanguage, firstWord, word, secondWord, filePath;
        int response;
        List<String> listDictionary,listWords;
        try {
            ExtraMethod.anonymousArray(new String[]{"Select the role", "1. Admin", "2. User"});
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Enter username: ");
                    username = sc.next();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    if (Login.loginRequest(username, password, ADMIN_LOGIN_PATH)) {
                        System.out.println();
                        System.out.println("Login successfully\n");
                        while (true) {
                            System.out.print("1 To continue 2 To log out: ");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println();
                                    ExtraMethod.anonymousArray(new String[]{"Which one do you want to do", "1. Create new dictionary",
                                            "2. Add a new word to the dictionary", "3. Remove the word from dictionary",
                                            "4. Change the word in dictionary", "5. Create new Admin"});
                                    switch (sc.nextInt()) {
                                        case 1:
                                            System.out.println("Current dictionaries in the file");
                                            listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                            listDictionary.forEach(System.out::println);

                                            System.out.println("Creating a new dictionary");
                                            System.out.print("Enter first language: ");
                                            fromLanguage = sc.next();
                                            System.out.print("Enter second language: ");
                                            toLanguage = sc.next();
                                            filePath=fromLanguage + "_" + toLanguage+".txt";
                                            Dictionary.createNewDictionary(filePath);
                                            Dictionary.writeLang(fromLanguage, toLanguage, ALL_DICTIONARY_NAMES_PATH);
                                            break;  //case1
                                        case 2:
                                            System.out.println("Current dictionaries in the file");
                                            listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                            listDictionary.forEach(System.out::println);

                                            System.out.println("Which dictionary do you want to add a word to?");
                                            System.out.print("Enter first language: ");
                                            fromLanguage = sc.next();
                                            System.out.print("Enter second language: ");
                                            toLanguage = sc.next();
                                            filePath = fromLanguage + "_" + toLanguage + ".txt";
                                            response = Dictionary.check(filePath, ALL_DICTIONARY_NAMES_PATH);
                                            if (response == 1) {
                                                System.out.println();
                                                System.out.println("Current words in dictionary");
                                                listWords=Dictionary.showCurrentInformation(filePath);
                                                listWords.forEach(System.out::println);
                                                System.out.println();
                                                System.out.print("Enter " + fromLanguage + " word: ");
                                                firstWord = sc.next();
                                                System.out.print("Enter " + toLanguage + " word: ");
                                                secondWord = sc.next();
                                                Dictionary.writeWordToDictionary(firstWord, secondWord, filePath);
                                                System.out.println("The word has been successfully added to the file\n");
                                            } else if (response == 2) {
                                                System.out.println("This dictionary name doesn't exist\n");
                                            } else {
                                                System.out.println("Error");
                                            }
                                            break;  //case2
                                        case 3:
                                            System.out.println("Which dictionary you want to remove the word from");
                                            listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                            listDictionary.forEach(System.out::println);

                                            System.out.print("Enter first language: ");
                                            fromLanguage = sc.next();
                                            System.out.print("Enter second language: ");
                                            toLanguage = sc.next();
                                            filePath = fromLanguage + "_" + toLanguage + ".txt";
                                            response = Dictionary.check(filePath, ALL_DICTIONARY_NAMES_PATH);
                                            if (response == 1) {
                                                System.out.println();
                                                System.out.println("Current words in dictionary");
                                                listWords=Dictionary.showCurrentInformation(filePath);
                                                listWords.forEach(System.out::println);
                                                System.out.println();
                                                System.out.print("Enter " + fromLanguage + " word: ");
                                                word = sc.next();
                                                Dictionary.removeWordFromDic(word, filePath);
                                            } else if (response == 2) {
                                                System.out.println("This dictionary name doesn't exist\n");
                                            } else {
                                                System.out.println("Error");
                                            }
                                            break; //case3
                                        case 4:
                                            System.out.println("Which dictionary you want to change the word from");
                                            listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                            listDictionary.forEach(System.out::println);

                                            System.out.print("Enter first language: ");
                                            fromLanguage = sc.next();
                                            System.out.print("Enter second language: ");
                                            toLanguage = sc.next();
                                            filePath = fromLanguage + "_" + toLanguage + ".txt";
                                            response = Dictionary.check(filePath, ALL_DICTIONARY_NAMES_PATH);
                                            if (response == 1) {
                                                System.out.println();
                                                System.out.println("Current words in dictionary");
                                                listWords=Dictionary.showCurrentInformation(filePath);
                                                listWords.forEach(System.out::println);
                                                System.out.println();
                                                System.out.print("Enter " + fromLanguage + " word: ");
                                                firstWord = sc.next();
                                                System.out.print("Enter the word to change: ");
                                                secondWord = sc.next();
                                                Dictionary.changeWordInDic(firstWord, secondWord, filePath);
                                            } else if (response == 2) {
                                                System.out.println("This dictionary name doesn't exist\n");
                                            } else {
                                                System.out.println("Error");
                                            }
                                            break;  //case4
                                        case 5:
                                            System.out.print("Enter username: ");
                                            username = sc.next();
                                            System.out.print("Enter password: ");
                                            password = sc.next();
                                            Login.register(username, password, ADMIN_LOGIN_PATH);
                                            break; //case5
                                        default:
                                            System.out.println("Invalid number\n");
                                    }
                                    break;   //case1
                                case 2:
                                    System.exit(0);
                                    break;   //case2
                                default:
                                    System.out.println("Invalid number\n");
                            }
                        }
                    } else {
                        System.out.println();
                        System.out.println("Wrong username or password");
                        chanceForAdmin--;
                        if (chanceForAdmin > 0) {
                            System.out.println("You have " + chanceForAdmin + " chances for enter\n");
                            main(args);
                        } else {
                            System.out.println("You have been blocked due to entered information incorrectly");
                            System.exit(0);
                        }
                    }
                    break;  //case1

                case 2:
                    while (true) {
                        System.out.println();
                        ExtraMethod.anonymousArray(new String[]{"Which one do you want to do", "1. View the current dictionaries in the system",
                                "2. Search the word in the current dictionary", "3. To log out"});
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Current dictionaries in the file");
                                listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                listDictionary.forEach(System.out::println);
                                break;  //case1
                            case 2:
                                System.out.println("Which dictionary do you want to use");
                                listDictionary = Dictionary.showCurrentInformation(ALL_DICTIONARY_NAMES_PATH);
                                listDictionary.forEach(System.out::println);

                                System.out.print("Enter first language: ");
                                fromLanguage = sc.next();
                                System.out.print("Enter second language: ");
                                toLanguage = sc.next();
                                filePath = fromLanguage + "_" + toLanguage + ".txt";
                                response = Dictionary.check(filePath, ALL_DICTIONARY_NAMES_PATH);
                                if (response == 1) {
                                    System.out.println("Which language you want to search by\n1. " + fromLanguage + "\n2. " + toLanguage);
                                    switch (sc.nextInt()) {
                                        case 1:
                                            System.out.print("Enter the " + fromLanguage + " word: ");
                                            secondWord = sc.next();
                                            result = "Translation: " + Dictionary.translate(secondWord, filePath, 1);
                                            break;   //case1
                                        case 2:
                                            System.out.print("Enter the " + toLanguage + " word: ");
                                            firstWord = sc.next();
                                            result = "Translation: " + Dictionary.translate(firstWord, filePath, 2);
                                            break;   //case2
                                        default:
                                            result = "Invalid dictionary type";
                                    }
                                    System.out.println(result);
                                } else if (response == 2) {
                                    System.out.println("This dictionary name doesn't exist");
                                } else {
                                    System.out.println("Error");
                                }
                                break;   //case2
                            case 3:
                                System.exit(0);
                                break;  //case3
                            default:
                                System.out.println("Invalid choose\n");
                        }
                    }
                default:
                    System.out.println("Invalid role\n");
                    main(args);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            main(args);
        } catch (InputMismatchException ex) {
            System.err.println("Enter correct input type\n");
            main(args);
        } catch (Exception ex) {
            ex.printStackTrace();
            main(args);
        }
    }
}
