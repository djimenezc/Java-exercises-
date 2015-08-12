package com.company.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by david on 12/08/2015.
 */
public class TwoDArray {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/TwoDArray/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

//        Scanner s = new Scanner(new File(INPUT_FILE));
        Scanner s = new Scanner(System.in);

        List<List<Integer>> inputArray = new ArrayList<List<Integer>>();

        while (s.hasNext()) {

            ArrayList<Integer> row = new ArrayList<Integer>();
            for (String cell : s.nextLine().split(" ")) {

                row.add(Integer.parseInt(cell));
            }

            inputArray.add(row);
        }


        Integer result = 0;

        for (int i = 0; i < (inputArray.size() / 2) + 1; i++) {

            List<Integer> row1 = inputArray.get(i);
            List<Integer> row2 = inputArray.get(i + 1);
            List<Integer> row3 = inputArray.get(i + 2);


            for (int j = 0; j < (row1.size() / 2) + 1; j++) {
                int tempResult = 0;

                tempResult += row1.get(j) + row1.get(j+1) + row1.get(j + 2);
                tempResult += row2.get(j+1);
                tempResult += row3.get(j) + row3.get(j+1) + row3.get(j + 2);

                if(tempResult > result) {
                    result = tempResult;
                }
            }

        }


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
