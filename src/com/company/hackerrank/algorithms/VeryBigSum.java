package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeryBigSum {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/veryBigSum/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        s.nextLine();
        String numbers = s.nextLine();

        Long result = new Long(0);

        for (String number : numbers.split(" ")) {

            result += Long.parseLong(number);
        }


        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        writer.println(result);
        System.out.println(result);

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