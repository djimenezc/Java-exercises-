package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDigits {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/findDigits/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());

        List<Boolean> resultArray = new ArrayList<Boolean>();

        for (int i = 0; i < t; i++) {
            int numDivisor = 0;

            String numberString = s.nextLine();
            int number = Integer.parseInt(numberString);

            for (char ch : numberString.toCharArray()) {

                int digit = Integer.parseInt(Character.toString(ch));
                if (digit != 0) {
                    if (number % digit == 0) {
                        numDivisor++;
                    }
                }
            }

            System.out.println(numDivisor);
            writer.println(numDivisor);
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