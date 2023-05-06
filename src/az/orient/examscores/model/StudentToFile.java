package az.orient.examscores.model;

import java.io.*;

public class StudentToFile {
    private static final String STUDENT_PATH = "D:\\Java\\Student";
    private static final String FILE_PATH = "D:\\Java\\Student\\student.txt";

    public static void studentWriteToFile(Student studentList) throws Exception {
        File f = new File(STUDENT_PATH);
        if (!f.exists()) {
            f.mkdir();
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            br.write(studentList.getName() + " " + studentList.getSurname() + " " + studentList.getMark());
            br.newLine();
        }
    }

    public static void onlyExcellent() throws Exception {
        FileReader fr = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String data = br.readLine();
            String[] strArr = data.split(" ");
            int mark = Integer.parseInt(strArr[2]);
            if (mark >= 91 && mark <= 100) {
                System.out.println(data);
            }
        }
    }

    public static void onlyGood() throws Exception {
        FileReader fr = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String data = br.readLine();
            String[] strArr = data.split(" ");
            int mark = Integer.parseInt(strArr[2]);
            if (mark >= 71 && mark < 91) {
                System.out.println(data);
            }
        }
    }

    public static void onlyNormal() throws Exception {
        FileReader fr = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String data = br.readLine();
            String[] strArr = data.split(" ");
            int mark = Integer.parseInt(strArr[2]);
            if (mark >= 51 && mark < 71) {
                System.out.println(data);
            }
        }
    }

    public static void onlyBad() throws Exception {
        FileReader fr = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String data = br.readLine();
            String[] strArr = data.split(" ");
            int mark = Integer.parseInt(strArr[2]);
            if (mark >= 0 && mark < 51) {
                System.out.println(data);
            }
        }
    }
}
