package com.company.hackerrank.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BigDecimalExample2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s = new Scanner(System.in);

        String firstLine = s.nextLine();
        ArrayList<BigDecimal> numbersArray = new ArrayList<BigDecimal>();


        for (int i = 0; i < Integer.parseInt(firstLine); i++) {

            numbersArray.add(new BigDecimal(s.nextLine()));
        }

        Collections.sort(numbersArray, Collections.reverseOrder());

        for (BigDecimal number: numbersArray) {

            System.out.println(number.toString().replaceAll("^0.","."));
        }


    }
}