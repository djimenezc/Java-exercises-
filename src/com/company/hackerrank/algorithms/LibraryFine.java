package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryFine {

    public static String FILE_NUMBER = "2";
    private static final String FILE_FOLDER = "files/libraryFine/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String actualReturnedDate = s.nextLine();
        String expectedDate = s.nextLine();


        int daysOfDifference = Integer.parseInt(actualReturnedDate.split(" ")[0]) - Integer.parseInt(expectedDate.split(" ")[0]);

        int monthsOfDifference = Integer.parseInt(actualReturnedDate.split(" ")[1]) - Integer.parseInt(expectedDate
                .split(" ")[1]);
        int yearsOfDifference = Integer.parseInt(actualReturnedDate.split(" ")[2]) - Integer.parseInt(expectedDate
                .split(" ")[2]);


        int fineCost = 10000 * yearsOfDifference + 500 * monthsOfDifference + 15 * daysOfDifference;
        fineCost = fineCost < 0 ? 0 : fineCost;

        System.out.println(fineCost);


        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        writer.println(fineCost);

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