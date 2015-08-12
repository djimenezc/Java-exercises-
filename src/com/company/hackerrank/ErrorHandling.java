package com.company.hackerrank;

import java.util.Scanner;

/**
 * Created by david on 12/08/2015.
 */
class myCalculator {

    public Integer power(int par1 ,int par2) throws Exception {

        if(par1< 0 || par2 < 0) {
            throw new Exception("n and p should be non-negative");
        }else {
            Double doubleValue = Math.pow(par1,par2);
            return  doubleValue.intValue();
        }
    }

}


public class ErrorHandling {

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt())
        {
            int n = in.nextInt();
            int p = in.nextInt();
            myCalculator M = new myCalculator();
            try
            {
                System.out.println(M.power(n,p));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
}