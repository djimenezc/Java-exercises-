package com.company.hackerrank;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HashSetExample {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/hashSetExample/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
//        String secondLine = s.nextLine();
//        String thirdLine = s.nextLine();

        HashSet<Pair<String, String>> pairHashSet = new HashSet<Pair<String, String>>();


        Integer n = Integer.parseInt(firstLine);
        boolean bool = false;

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");


        for (int i = 0; i < n; i++) {

            String line = s.nextLine();

            pairHashSet.add(new Pair<String, String>(line.split(" ")[0], line.split(" ")[1]));

            System.out.println(pairHashSet.size());
            writer.println(pairHashSet.size());
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