package com.company.hackerrank.java;

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String string = s.nextLine();
        int substringLength = Integer.parseInt(s.nextLine());
//        String string = "welcometojava";
//        int substringLength = 3;

        String minSubString = new String(new char[substringLength]).replace('\0', 'z');
        String maxSubString = new String(new char[substringLength]).replace('\0', 'A');;

        for (int i = 0; i < string.length() - substringLength + 1; i++) {

            String substring = string.substring(i, i + substringLength);

//            System.out.println(substring);

            if (substring.compareTo(minSubString) < 0) {
                minSubString = substring;
            }
            if (substring.compareTo(maxSubString) > 0) {
                maxSubString = substring;
            }
        }

//        System.out.println("+++++++++++++");

        System.out.println(minSubString);
        System.out.println(maxSubString);
    }
}