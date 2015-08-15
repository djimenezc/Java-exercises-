package com.company.hackerrank.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Template {

//    assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));

    private Collection<Object> collection;

    @Before
    public void setUp() {

        collection = new ArrayList<Object>();
    }

    @Test
    public void validIpAddress() {


        // assert statements
//        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertTrue(true);
    }

}
