package com.company.hackerrank.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndSquares {

    public static String FILE_NUMBER = "2";
    private static final String FILE_FOLDER = "files/sherlockAndSquares/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer t = Integer.parseInt(s.nextLine());

        for (int i = 0; i < t; i++) {

            String line = s.nextLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            int numberSquares =  (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);


//            for (int j = a; j <= b; j++) {
////                double square = Math.sqrt(j);
////                if(square % 1 == 0) { //it is whole number
////                    numberSquares++;
////                }
//                int number = j;
//                int sqrt = (int) Math.sqrt(number);
//                if (sqrt * sqrt == number) {
//                    numberSquares++;
//                }
//
//            }

            System.out.println(numberSquares);
            writer.println(numberSquares);
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