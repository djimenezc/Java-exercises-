package com.company.hackerrank.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.company.hackerrank.java.MyRegex;
import org.junit.Before;
import org.junit.Test;

public class MyRegexTest {

//    assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));

    private MyRegex myRegex;

    @Before
    public void setUp() {

        myRegex = new MyRegex();
    }

    @Test
    public void testValidIpAddress() {

        // MyClass is tested

        // assert statements
        assertTrue("Valid IP", myRegex.validate("212.212.212.212"));
//        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }

}
