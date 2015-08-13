package com.company.hackerrank.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s = new Scanner(System.in);

        Integer numberSeries = Integer.parseInt(s.nextLine());
        String tripleSet;

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> n = new ArrayList<Integer>();

        for (int i = 0; i < numberSeries; i++) {

            tripleSet = s.nextLine();

            a.add(Integer.parseInt(tripleSet.split(" ")[0]));
            b.add(Integer.parseInt(tripleSet.split(" ")[1]));
            n.add(Integer.parseInt(tripleSet.split(" ")[2]));
        }


        for (int i = 0; i < numberSeries; i++) {

            Double value = Double.valueOf(a.get(i));

            for (int j = 0; j < n.get(i); j++) {

                value = value + b.get(i) * Math.pow(2, j);
                System.out.print(value.intValue() + " ");
            }

            System.out.print("\n");
        }
    }
}