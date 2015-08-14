package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheGridSearch {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/theGridSearch/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    private static List<int[]> readGrid(Scanner s, int c, int r) {

        List<int[]> grid = new ArrayList<int[]>();

        for (int j = 0; j < c; j++) {
            String row = s.nextLine();
            int[] arrayRow = new int[r];
            grid.add(arrayRow);
            for (int k = 0; k < r; k++) {
                arrayRow[k] = Integer.parseInt(String.valueOf(row.charAt(k)).toLowerCase());
            }
        }

        return grid;
    }

    private static String findPattern(List<int[]> grid, List<int[]> pattern) {


        String result = "NO";

        for (int i = 0; i < grid.size() - pattern.size(); i++) {
            for (int j = 0; j < grid.get(0).length - pattern.get(0).length; j++) {
                boolean isNotValid = false;

                for (int k = 0; k < pattern.size(); k++) {
                    if(isNotValid) {
                        break;
                    }
                    for (int m = 0; m < pattern.get(0).length; m++) {
                        if(grid.get(i + k)[j + m] != pattern.get(k)[m]) {
                            isNotValid = true;
                            break;
                        } else {
                            if(k + 1 == pattern.size() && m + 1 == pattern.get(0).length) {
                                return "YES";
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());
        String result = "";

        List<Boolean> resultArray = new ArrayList<Boolean>();

        for (int i = 0; i < t; i++) {

            String numbersGrid = s.nextLine();
            int c = Integer.parseInt(numbersGrid.split(" ")[0]);
            int r = Integer.parseInt(numbersGrid.split(" ")[1]);

            List<int[]> grid = readGrid(s, c, r);

            String numbersPattern = s.nextLine();
            c = Integer.parseInt(numbersPattern.split(" ")[0]);
            r = Integer.parseInt(numbersPattern.split(" ")[1]);

            List<int[]> pattern = readGrid(s, c, r);

            result = findPattern(grid, pattern);

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