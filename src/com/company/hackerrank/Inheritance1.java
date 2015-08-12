package com.company.hackerrank;


/**
 * Created by david on 12/08/2015.
 */

abstract class Arithmetic {

    abstract int add(int x, int y);
}

class Adder extends Arithmetic {

    public int add(int x, int y) {
        return x + y;
    }

}

public class Inheritance1 {

    public static void main(String[] argh) {

        Adder X = new Adder();
        System.out.println("My superclass is: " + X.getClass().getSuperclass().getName());
        System.out.print(X.add(10, 32) + " " + X.add(10, 3) + " " + X.add(10, 10) + "\n");
    }
}
