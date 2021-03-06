package com.company.hackerrank.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneDArrayHard {

    public static String FILE_NUMBER = "3";
    private static final String FILE_FOLDER = "files/1Darray/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


//        Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File(INPUT_FILE));

        String firstLine = s.nextLine();

        int t = Integer.parseInt(firstLine);
        List<Integer> nArray = new ArrayList<Integer>();
        List<Integer> mArray = new ArrayList<Integer>();
        List<List<Integer>> pathArray = new ArrayList<List<Integer>>();
        List<Boolean> resultArray = new ArrayList<Boolean>();

        for (int i = 0; i < t; i++) {

            String secondLine = s.nextLine();
            String thirdLine = s.nextLine();

            nArray.add(Integer.parseInt(secondLine.split(" ")[0]));
            mArray.add(Integer.parseInt(secondLine.split(" ")[1]));
            List<Integer> a = new ArrayList<Integer>();

            for (String step : thirdLine.split(" ")) {
                a.add(Integer.parseInt(step));
            }

            pathArray.add(a);
        }

        for (int i = 0; i < t; i++) {

            int n = nArray.get(i);
            int m = mArray.get(i);
            List<Integer> path = pathArray.get(i);

            int position = 0;
            Boolean backward = false;

            do {

                if (position + 1 > n - 1 || position + m > n - 1) {
                    resultArray.add(i, true);
                } else {

                    if (path.get(position + 1) == 0 && !backward) {
                        position += 1;
                        backward = false;
                    } else if (path.get(position + m) == 0) {
                        position += m;
                        backward = false;
                    } else if (position - 1 > 0 && path.get(position - 1) == 0) {
                        position -= 1;
                        backward = true;
                    } else {
                        //not possible to win
                        resultArray.add(i, false);
                        break;
                    }
                }

                if (position > n - 1 && path.get(position) == 0) {
                    resultArray.add(i, true);
                } else if (position > n - 1) {
                    resultArray.add(i, false);
                }
            } while (i >= 0 && i == resultArray.size());

        }


        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        for (Boolean result : resultArray) {

            if (result) {

                System.out.println("YES");
                writer.println("YES");
            } else {

                System.out.println("NO");
                writer.println("NO");
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
                System.out.println("Failing in line "+ (lineNumber+1));
            }
            lineNumber++;
        }

        System.out.println("Verification " + isOutputCorrect);
    }
}