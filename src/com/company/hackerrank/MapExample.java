package com.company.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapExample {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/map/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
//        String secondLine = s.nextLine();
//        String thirdLine = s.nextLine();


        int n = Integer.parseInt(firstLine);

        Map<String, Integer> phoneBook = new HashMap<String, Integer>();


        for (int j = 0; j < n; j++) {

            String name = s.nextLine();
            Integer phoneNumber = Integer.parseInt(s.nextLine());
            phoneBook.put(name, phoneNumber);
        }

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        while (s.hasNext()) {

            String name = s.nextLine();
            String msg;

            if(phoneBook.containsKey(name)) {
                msg =  name + "=" + phoneBook.get(name).intValue();
                System.out.println(msg);
                writer.println(msg);
            } else {
                System.out.println("Not found");
                writer.println("Not found");
            }
        }

        writer.close();

        Scanner sOutput = new Scanner(new File(RESULT_FILE));
        Scanner sExpectedOut = new Scanner(new File(EXPECTED_RESULT_FILE));

        boolean isOutputCorrect = true;
        int lineNumber = 0;

        while (sOutput.hasNext() && sExpectedOut.hasNext()) {

            String resultLine = sOutput.nextLine();
            String expectedResultLine = sExpectedOut.nextLine();

            if (!resultLine.equals(expectedResultLine)) {
                isOutputCorrect = false;
                System.out.println("Failing in line " + (lineNumber + 1));
            }
            lineNumber++;
        }

        System.out.println("Verification " + isOutputCorrect);
    }
}