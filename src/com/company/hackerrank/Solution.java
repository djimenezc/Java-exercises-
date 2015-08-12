package com.company.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String FILE_NUMBER = "3";
    private static final String FILE_FOLDER = "files/1Darray/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


//        Scanner s = new Scanner(new File("files/1Darray/input1.txt"));
        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
        String secondLine = s.nextLine();
        String thirdLine = s.nextLine();

        List<Boolean> resultArray = new ArrayList<Boolean>();



        System.out.println();

        boolean bool = false;

        while (bool) {

        }

        try {

        } catch (Exception e1) {

        }

        ArrayList<String> result = new ArrayList<String>();

        for (String string: result) {

        }

        for (int i = 0; i < 10; i++) {

        }


        for (Boolean resultVar : resultArray) {

            if (resultVar) {

                System.out.println("YES");
                writer.println("YES");
            } else {

                System.out.println("NO");
                writer.println("NO");
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
                System.out.println("Failing in line "+ (lineNumber+1));
            }
            lineNumber++;
        }

        System.out.println("Verification " + isOutputCorrect);
    }
}