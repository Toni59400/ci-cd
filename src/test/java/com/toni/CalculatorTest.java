package com.toni;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd_ok() {
        assertEquals("error in add()", 5, Calculator.add(2, 3));
        assertNotEquals("error in add()", -5, Calculator.add(5, 0));
        assertEquals(0, Calculator.add(0, 0));
        assertEquals(-3, Calculator.add(-1, -2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivInt_throws_on_zero() {
        Calculator.divInt(10, 0);
    }

    @Test
    public void testDivReal_ok() {
        assertEquals(2.5, Calculator.divReal(5, 2), 1e-9);
        assertEquals(0.5, Calculator.divReal(1, 2), 1e-12);
    }
}
