package com.company.hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyRegex {

//    assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));

    private Collection<Object> collection;

    @Before
    public void setUp() {
        collection = new ArrayList<Object>();
    }

    @Test
    public void validIpAddress() {

        // MyClass is tested
        MyClass tester = new MyClass();

        // assert statements
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }

}
