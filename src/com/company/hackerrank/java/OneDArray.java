package com.company.hackerrank.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OneDArray {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
        String secondLine = s.nextLine();
//        String firstLine = "5";
//        String secondLine = "1 -2 4 -5 1";

        int negativeSubArrayCounter = 0;

        List<String> numbersArray = Arrays.asList(secondLine.split(" "));


        for (int i = 0; i < Integer.parseInt(firstLine); i++) {
            int tempCounter = 0;

            for (int j = i; j < Integer.parseInt(firstLine); j++) {

                tempCounter += Integer.parseInt(numbersArray.get(j));

                if(tempCounter < 0) {
                    negativeSubArrayCounter++;
//                    System.out.println("["+i+","+j+"]");
                }
            }
        }

        System.out.println(negativeSubArrayCounter);
    }
}