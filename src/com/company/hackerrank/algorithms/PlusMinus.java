package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlusMinus {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/plusMinus/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer numberEntries = Integer.parseInt(s.nextLine());
//        Integer numberEntries = s.nextInt();
        String numbers = s.nextLine();

        long positiveNumber = 0;
        long zeroNumber = 0;
        long negativeNumber = 0;

        for (String string : numbers.split(" ")) {

            if (Integer.parseInt(string) > 0) {
                positiveNumber++;
            } else if (Integer.parseInt(string) < 0) {
                negativeNumber++;
            } else {
                zeroNumber++;
            }
        }

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println(df.format((double) positiveNumber / numberEntries));
        System.out.println(df.format((double) negativeNumber / numberEntries));
        System.out.println(df.format((double) zeroNumber / numberEntries));


        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        writer.println(df.format((double) positiveNumber / numberEntries));
        writer.println(df.format((double) negativeNumber / numberEntries));
        writer.println(df.format((double) zeroNumber / numberEntries));

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