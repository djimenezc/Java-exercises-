package com.company.hackerrank.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyRegex {

//    assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));

    private MyRegex myRegex;

    @Before
    public void setUp() {
        myRegex = new MyRegex();
    }

    @Test
    public void validIpAddress() {

        // MyClass is tested
        MyClass tester = new MyClass();

        // assert statements
        assertTrue("Valid IP", myRegex.pattern());
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }

}
