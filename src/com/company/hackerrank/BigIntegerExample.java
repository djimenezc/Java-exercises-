package com.company.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerExample {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s = new Scanner(System.in);

        String firstLine = s.nextLine();
        String secondLine = s.nextLine();



        BigInteger first = new BigInteger(firstLine);
        BigInteger second = new BigInteger(secondLine);

        BigInteger sum = first.add(second);
        BigInteger multiply = first.multiply(second);

        System.out.println(sum.toString());
        System.out.println(multiply.toString());


    }
}