package com.company.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class DataType {

    public static void main(String[] args) {

//        String input = "213333333333333333333333333333333333";

        Scanner s = new Scanner(System.in);
        Integer numberEntries = Integer.parseInt(s.nextLine());
        ArrayList<String> entryArray = new ArrayList<String>();


        while (entryArray.size() != numberEntries) {

            entryArray.add(s.nextLine());
        }

        for (String input : entryArray) {

            boolean isInteger = false;
            boolean isShort = false;
            boolean isLong = false;
            boolean isByte = false;

            try {
                Integer.parseInt(input);
                isInteger = true;
            } catch (Exception e1) {
            }
            try {
                Short.parseShort(input);
                isShort = true;
            } catch (Exception e1) {
            }
            try {
                Byte.parseByte(input);
                isByte = true;
            } catch (Exception e1) {
            }
            try {
                Long.parseLong(input);
                isLong = true;
            } catch (Exception e1) {
            }


            if (!isInteger && !isShort && !isLong) {

                System.out.println(input + " can't be fitted anywhere.");
            } else {

                System.out.println(input + " can be fitted in:");
                if (isByte) {
                    System.out.println("* byte");
                }
                if (isShort) {
                    System.out.println("* short");
                }
                if (isInteger) {
                    System.out.println("* int");

                }
                if (isLong) {
                    System.out.println("* long");

                }
            }
        }

    }
}