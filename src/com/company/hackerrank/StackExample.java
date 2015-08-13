package com.company.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackExample {

    public static String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/stackExample/";
    public static String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);

        ArrayList<String> inputArrayList = new ArrayList<String>();

        while (s.hasNext()) {
            inputArrayList.add(s.nextLine());
        }

        boolean result = false;
        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");

        for (String string: inputArrayList) {

            Stack<Character> st = new Stack<Character>();

            for (Character ch: string.toCharArray()) {

                if(ch == '{' || ch == '[' || ch == '(') {
                    st.push(ch);
                } else {
                    if(ch == '}' && st.peek() == '{') {
                        st.pop();
                    } else if(ch == ']' && st.peek() == '[') {
                        st.pop();
                    } else if(ch == ')' && st.peek() == '(') {
                        st.pop();
                    } else {
                        break;// unbalanced
                    }
                }
            }

            result = st.empty();

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
                System.out.println("Failing in line "+ (lineNumber+1));
            }
            lineNumber++;
        }

        System.out.println("Verification " + isOutputCorrect);
    }
}