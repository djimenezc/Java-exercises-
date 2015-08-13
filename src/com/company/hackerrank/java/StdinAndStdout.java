package com.company.hackerrank.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by david on 11/08/2015.
 */
public class StdinAndStdout {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();

        while (result.size() != 3) {

            result.add(s.nextLine());
        }


        System.out.println("String: " + result.get(2));
        System.out.println("Double: " + Double.parseDouble(result.get(1)));
        System.out.println("Int: " + result.get(0));


//        for (int i = result.size() - 1; i >= 0; i--) {
//
//            try {
//
//                int x = Integer.parseInt(result.get(i));
//                System.out.println("Int: " + x);
//            } catch (Exception e1) {
//
//                try {
//                    Double d = Double.parseDouble(result.get(i));
//                    System.out.println("Double: " + d);
//                } catch (Exception e2) {
//                    System.out.println("String: " + result.get(i));
//                }
//            }
//        }
    }
}
