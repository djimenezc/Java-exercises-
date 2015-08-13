package com.company.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaesarCipher {

    public static String FILE_NUMBER = "2";
    private static final String FILE_FOLDER = "files/caesarCipher/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        Integer stringLength =  Integer.parseInt(s.nextLine());
        String string = s.nextLine();
        int k = Integer.parseInt(s.nextLine());


        char[] charArray = string.toCharArray();

        for (int i = 0; i < stringLength; i++) {

            if(Character.isLetter(charArray[i])) {
                boolean isUppercase = charArray[i] > 64 && charArray[i] < 91;
//                charArray[i] = (char) (charArray[i] + k);
                char ch = charArray[i];

                if(isUppercase) {
                    charArray[i] = (char) ('A' + (ch - 'A' + k) % 26);
                } else if(!isUppercase) {
                    charArray[i] = (char) ('a' + (ch - 'a' + k) % 26);
                }
            }
        }

        System.out.println(new String(charArray));

            PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        writer.println(new String(charArray));

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