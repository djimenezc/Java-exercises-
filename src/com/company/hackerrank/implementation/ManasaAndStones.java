package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaAndStones {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/manasaAndStones/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());

        for (int i = 0; i < t; i++) {
            Integer n = Integer.parseInt(s.nextLine());
            Integer a = Integer.parseInt(s.nextLine());
            Integer b = Integer.parseInt(s.nextLine());
            StringBuilder builder = new StringBuilder();

            Set<Integer> solutions = new TreeSet<Integer>();

            for (int j = 0; j < n; j++) {

                solutions.add(a * j + b * (n - j - 1));
            }

            for (Integer value : solutions) {
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(value);
            }

            System.out.println(builder.toString());
            writer.println(builder.toString());
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