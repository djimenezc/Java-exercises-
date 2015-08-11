package com.company.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OutputFormatting {

    //http://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();

        while (result.size() != 3) {

            result.add(s.nextLine());
        }


        System.out.println("================================");
        System.out.format("%-15s%03d\n", result.get(0).split(" ")[0], Integer.parseInt(result.get(0).split(" ")[1]));
        System.out.format("%-15s%03d\n", result.get(1).split(" ")[1], Integer.parseInt(result.get(1).split(" ")[1]));
        System.out.format("%-15s%03d\n", result.get(2).split(" ")[2], Integer.parseInt(result.get(2).split(" ")[1]));
        System.out.println("================================");

    }
}