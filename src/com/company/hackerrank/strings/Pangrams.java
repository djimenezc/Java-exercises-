package com.company.hackerrank.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Pangrams {

    private static final String LETTER_PATTERN = "[a-zA-Z]";
    public static final String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/Pangrams/";
    public static final String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static final String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static final String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        String result = "";

        Pattern pattern = Pattern.compile(LETTER_PATTERN);

        List<Boolean> resultArray = new ArrayList<Boolean>();

        Set<Character> alphabetSet = new HashSet<Character>();

        for (int i = 0; i < string.length(); i++) {

            if( pattern.matcher(Character.toString(string.charAt(i))).matches()) {
                alphabetSet.add(Character.toLowerCase(string.charAt(i)));
            }
        }


        if(alphabetSet.size() ==26 ){
            result = "pangram";
        } else {
            result = "not pangram";
        }

        System.out.println(result);
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