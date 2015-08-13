package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Staircase {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/staircase/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

//        Scanner s = new Scanner(System.in);
        Integer numberEntries = Integer.parseInt(s.nextLine());

        List<String> resultArray = new ArrayList<String>();

        for (int i = 0; i < numberEntries; i++) {
            String row = "";
            for (int j = 0; j < numberEntries; j++) {

                if (i < j + 1) {

                    row += "#";
                } else {
                    row += " ";
                }
            }
            resultArray.add(row);
//            System.out.println(row);
//            writer.println(row);
        }


        ListIterator<String> iter = resultArray.listIterator(resultArray.size());

        while (iter.hasPrevious()) {
            String row = iter.previous();
            System.out.println(row);
//            writer.println(row);
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