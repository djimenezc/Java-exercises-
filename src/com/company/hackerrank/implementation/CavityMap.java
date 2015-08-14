package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CavityMap {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/cavityMap/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    private static List<Integer[]> readGrid(Scanner s, int c, int r) {

        List<Integer[]> grid = new ArrayList<Integer[]>();

        for (int j = 0; j < c; j++) {
            String row = s.nextLine();
            Integer[] arrayRow = new Integer[r];
            grid.add(arrayRow);
            for (int k = 0; k < r; k++) {
                arrayRow[k] = Integer.parseInt(String.valueOf(row.charAt(k)).toLowerCase());
            }
        }

        return grid;
    }

    public static List<Integer[]> cloneList(List<Integer[]> list) {

        List<Integer[]> clone = new ArrayList<Integer[]>(list.size());

        for (Integer[] item : list) {

            clone.add(cloneArray(item));
        }

        return clone;
    }

    private static Integer[] cloneArray(Integer[] item) {

        Integer[] result = new Integer[item.length];

        for (int i = 0; i < item.length; i++) {

            result[i] = item[i];
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());
        String result = "";

        List<Integer[]> grid = readGrid(s, t, t);
        List<Integer[]> newGrid = cloneList(grid);

        for (int i = 1; i < grid.size() - 1; i++) {

            for (int j = 1; j < grid.size() - 1; j++) {

                int cavityDepth = grid.get(i)[j];

                if (grid.get(i - 1)[j] < cavityDepth && grid.get(i + 1)[j] < cavityDepth && grid.get(i)[j - 1] <
                        cavityDepth && grid.get(i - 1)[j + 1] <= cavityDepth) {

                    newGrid.get(i)[j] = -1;
                }
            }
        }

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {

                result = newGrid.get(i)[j] == -1 ? "X" : newGrid.get(i)[j].toString();

                System.out.print(result);
                writer.print(result);
            }
            System.out.print("\n");
            writer.print("\n");
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