package com.company.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();

        while (s.hasNext()) {
            result.add(s.nextLine());
        }

        for (int i = 0; i < result.size(); i++) {

            System.out.println((i+1) + " " + result.get(i));
        }
    }
}