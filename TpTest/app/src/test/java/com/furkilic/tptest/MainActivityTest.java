package com.furkilic.tptest;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by furki on 07/07/2017.
 */

public class MainActivityTest {

    @Test
    public void testEquality_FirstString_SecondString_null_null(){
        MainActivity mainActivity= new MainActivity();
        String firstString=null;
        String secondString=null;
        boolean result=mainActivity.isTwoStringEqual(firstString, secondString);
        assertTrue(result);
    }

    @Test
    public void testEquality_FirstString_SecondString_null_notnull(){
        MainActivity mainActivity= new MainActivity();
        String firstString=null;
        String secondString="TOTO";
        boolean result=mainActivity.isTwoStringEqual(firstString, secondString);
        assertFalse(result);
    }

    @Test
    public void testEquality_FirstString_SecondString_notnull_null(){
        MainActivity mainActivity= new MainActivity();
        String firstString="TOTO";
        String secondString=null;
        boolean result=mainActivity.isTwoStringEqual(firstString, secondString);
        assertFalse(result);
    }

    @Test
    public void testEquality_FirstString_SecondString_notnull_notnull(){
        MainActivity mainActivity= new MainActivity();
        String firstString="TOTO";
        String secondString="TOTO";
        boolean result=mainActivity.isTwoStringEqual(firstString, secondString);
        assertTrue(result);
    }
}
