package com.company.hackerrank.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunnyString {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/funnyString/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());
        String result = "";

        List<Boolean> resultArray = new ArrayList<Boolean>();

        for (int i = 0; i < t; i++) {

            String string = s.nextLine();
            String reverseString = new StringBuilder(string).reverse().toString();
            result = "Funny";

            for (int j = 1; j < string.length() - 1; j++) {

                if (Math.abs(string.charAt(j) - string.charAt(j + 1)) != Math.abs(reverseString.charAt(j) -
                        reverseString.charAt(j +
                        1))) {
                    result = "Not Funny";
                    break;
                }
            }

            System.out.println(result);
            writer.println(result);
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