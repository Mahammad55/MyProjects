package az.orient.examscores.main;

import az.orient.examscores.method.Methods;
import az.orient.examscores.model.Dean;
import az.orient.examscores.model.LabAssistant;
import az.orient.examscores.model.Student;
import az.orient.examscores.model.StudentToFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int chanceForDean = 3;
    public static int chanceForLabAssistant = 2;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        try {
            Methods.anonymousArray(new String[]{"Select one", "1. Dean", "2. LabAssistant"});
            switch (sc.nextInt()) {
                case 1: {
                    System.out.print("Enter login username: ");
                    String username = sc.next();
                    System.out.print("Enter login password: ");
                    String password = sc.next();
                    if (Dean.deanLogin(username, password)) {
                        System.out.println("Login successful.\n");
                        while (true) {
                            System.out.println("1 to continue, 2 to log out");
                            switch (sc.nextInt()) {
                                case 1: {
                                    Methods.anonymousArray(new String[]{"Select one", "1. Register LabAssistant", "2. Read Students"});
                                    switch (sc.nextInt()) {
                                        case 1: {
                                            System.out.print("Enter username: ");
                                            String labUsername = sc.next();
                                            System.out.print("Enter password: ");
                                            String labPassword = sc.next();
                                            Dean.register(labUsername, labPassword);
                                            break;
                                        }
                                        case 2: {
                                            Methods.anonymousArray(new String[]{"Which one do you want to read.",
                                                    "1. All of students ", "2. Only excellent marks ",
                                                    "3. Only good marks", "4. Only normal marks", "5. Only bad marks"});
                                            switch (sc.nextInt()) {
                                                case 1: {
                                                    System.out.println("Excellent Students:");
                                                    StudentToFile.onlyExcellent();
                                                    System.out.println("---------------");
                                                    System.out.println("Good students:");
                                                    StudentToFile.onlyGood();
                                                    System.out.println("---------------");
                                                    System.out.println("Normal Students:");
                                                    StudentToFile.onlyNormal();
                                                    System.out.println("---------------");
                                                    System.out.println("Bad students:");
                                                    StudentToFile.onlyBad();
                                                    System.out.println();
                                                    break;
                                                }
                                                case 2: {
                                                    System.out.println("Excellent Students:");
                                                    StudentToFile.onlyExcellent();
                                                    System.out.println();
                                                    break;
                                                }
                                                case 3: {
                                                    System.out.println("Good students:");
                                                    StudentToFile.onlyGood();
                                                    System.out.println();
                                                    break;
                                                }
                                                case 4: {
                                                    System.out.println("Normal Students:");
                                                    StudentToFile.onlyNormal();
                                                    System.out.println();
                                                    break;
                                                }
                                                case 5: {
                                                    System.out.println("Bad students:");
                                                    StudentToFile.onlyBad();
                                                    System.out.println();
                                                    break;
                                                }
                                                default: {
                                                    System.err.println("Invalid method! \n");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        default: {
                                            System.err.println("Invalid Number");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2:
                                    System.exit(0);
                                    break;
                                default:
                                    System.err.println("Invalid number!");
                            }
                        }
                    } else {
                        System.out.println("Wrong username or password!\n");
                        chanceForDean--;
                        if (chanceForDean > 0) {
                            System.out.println("You have " + chanceForDean + " chances left for enter\n");
                            main(args);
                        } else {
                            System.out.println("You have been blocked due to you entered information incorrectly");
                            System.exit(0);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter login username: ");
                    String username = sc.next();
                    System.out.print("Enter login password: ");
                    String password = sc.next();
                    if (LabAssistant.labAssistantLogin(username, password)) {
                        System.out.println("Login successful.");
                        while (true) {
                            System.out.println("1 to enter a student,2 to log out");
                            switch (sc.nextInt()) {
                                case 1: {
                                    Student student = new Student();
                                    System.out.print("Enter student name: ");
                                    student.setName(sc.next());
                                    System.out.print("Enter student surname: ");
                                    student.setSurname(sc.next());
                                    System.out.print("Enter student mark: ");
                                    int mark = sc.nextInt();
                                    if (mark > 100 || mark < 0) {
                                        System.out.println("The mark of student must be between 0-100");
                                    } else {
                                        student.setMark(mark);
                                        StudentToFile.studentWriteToFile(student);
                                    }
                                    break;
                                }
                                case 2: {
                                    System.exit(0);
                                    break;
                                }
                                default: {
                                    System.err.println("Invalid number! \n");
                                    break;
                                }
                            }
                        }
                    } else {
                        chanceForLabAssistant--;
                        System.out.println("Wrong username or password! \n");
                        if (chanceForLabAssistant > 0) {
                            System.out.println("You have " + chanceForLabAssistant + " chances left");
                            main(args);
                        } else {
                            System.out.println("You have been blocked due to you entered information incorrectly");
                            System.exit(0);
                        }
                    }
                    break;
                }
                default: {
                    System.err.println("Invalid Number! \n");
                    main(args);
                }
            }
        } catch (InputMismatchException ex) {
            System.err.println("Chose must be a number \n");
            main(args);
        } catch (Exception ex) {
            ex.printStackTrace();
            main(args);
        }
    }
}