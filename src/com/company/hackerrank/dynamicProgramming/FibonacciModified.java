package com.company.hackerrank.dynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciModified {

    public static final String FILE_NUMBER = "1";
    private static final String FILE_FOLDER = "files/FibonacciModified/";
    public static final String INPUT_FILE = FILE_FOLDER + "input" + FILE_NUMBER + ".txt";
    public static final String EXPECTED_RESULT_FILE = FILE_FOLDER + "output" + FILE_NUMBER + ".txt";
    public static final String RESULT_FILE = "files/tmp/tmp.txt";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(RESULT_FILE, "UTF-8");
        Scanner s = new Scanner(new File(INPUT_FILE));
//        Scanner s = new Scanner(System.in);
        String numbers = s.nextLine();
        BigInteger result;

        Long b = Long.parseLong(numbers.split(" ")[1]);
        Long a = Long.parseLong(numbers.split(" ")[0]);
        int n = Integer.parseInt(numbers.split(" ")[2]);

        List<BigInteger> series = new ArrayList<BigInteger>();

        series.add(BigInteger.valueOf(a));
        series.add(BigInteger.valueOf(b));

        while (series.size() < n) {
            series.add(series.get(series.size() - 2).add(series.get(series.size() - 1).pow(2)));
        }

        result = fibo(n, a, b);

//        result = series.get(n - 1);

        System.out.println(result.toString());
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

    private static BigInteger fibo(int n, long a, long b) {

        BigInteger result;

        if (n == 0) {
            result = BigInteger.valueOf(0);
        } else if (n == 1) {
            result = BigInteger.valueOf(a);;
        } else if (n == 2) {
            result = BigInteger.valueOf(b);;
        } else {
            result = (fibo(n - 1, a, b).pow(2)).add(fibo(n - 2, a, b));
        }

        return result;
    }
}