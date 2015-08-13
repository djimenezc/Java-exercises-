package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Sherlock {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/sherlock/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());

        for (int i = 0; i < t; i++) {
            String string = s.nextLine();
            Integer numberString = Integer.parseInt(string);

            String result = "";
            int threeCounter = numberString / 3;
            int fiveCounter = 0;

            while (threeCounter >= 0) {

                int rem = numberString - threeCounter * 3;
                if (rem % 5 == 0) {

                    fiveCounter = rem / 5;
                    break;
                }
                threeCounter -= 1;
            }

            if (threeCounter <= 0 && fiveCounter == 0) {

                result = "-1";
            } else {
                result = new String(new char[threeCounter]).replace("\0", "555") + new String(new char[fiveCounter]).replace
                        ("\0", "33333" );
            }

            System.out.println(result);
            writer.println(result);
        }

        writer.close();

        Scanner sOutput = new Scanner(new File(RESULT_FILE));
        Scanner sExpectedOut = new Scanner(new File(EXPECTED_RESULT_FILE));

        boolean isOutputCorrect = true;
        int lineNumber = 0;

        while (sOutput.hasNext() && sExpectedOut.hasNext())

        {

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