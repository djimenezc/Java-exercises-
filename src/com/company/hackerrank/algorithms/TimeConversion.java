package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeConversion {

    public static String FILE_NUMBER = "2";
    private static final String FILE_FOLDER = "files/timeConversion/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        List<Boolean> resultArray = new ArrayList<Boolean>();

        Integer hh = Integer.parseInt(input.substring(0, 2));
        String mm = input.substring(3, 5);
        String ss = input.substring(6, 8);
        String amPm = input.substring(8, 10);


        if (amPm.equals("PM")) {
            hh += 12;
        } else if (amPm.equals("AM") && hh ==12){
            hh = 0;
        }

        String newHh = String.format("%02d", hh);

        String result = newHh + ":" + mm + ":" + ss;
        System.out.println(result);


        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");


        writer.println(result);

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