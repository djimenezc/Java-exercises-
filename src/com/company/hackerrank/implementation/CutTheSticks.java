package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    public static String FILE_NUMBER = "2";
    private static final String FILE_FOLDER = "files/cutTheSticks/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());
        String numbers = s.nextLine();
        String result = "";

        List<Integer> sticks = new ArrayList<Integer>();

        for (String resultVar : numbers.split(" ")) {
            sticks.add(Integer.parseInt(resultVar));
        }

        int sticksLeft = t;

        while (sticksLeft > 0) {

            sticksLeft = 0;
            int sticksCutLength = Integer.MAX_VALUE;

            for (int i = 0; i < sticks.size(); i++) {

                if (sticks.get(i) > 0) {
                    sticksLeft++;
                    //updating stick cut length
                    if(sticksCutLength > sticks.get(i)) {
                        sticksCutLength = sticks.get(i);
                    }
                }

            }

            if (sticksLeft > 0) {
                System.out.println(sticksLeft);
                writer.println(sticksLeft);
                for (int i = 0; i < sticks.size(); i++) {

                    sticks.set(i, sticks.get(i) - sticksCutLength);
                }
            }

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