package com.volkov;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAddForNoOperand() {
        int expectedResult = 0;
        int actualResult = Calculator.add();
        assertEquals("Wrong result", expectedResult, actualResult);
    }

    @Test
    public void testAddForOneOperand() {
        int operand1 = 1;
        int expectedResult = 1;
        int actualResult = Calculator.add(operand1);
        assertEquals("Wrong result", expectedResult, actualResult);
    }

    @Test
    public void testAddForTwoOperand() {
        int operand1 = 1;
        int operand2 = 2;
        int expectedResult = 3;
        int actualResult = Calculator.add(operand1, operand2);
        assertEquals("Wrong result", expectedResult, actualResult);
    }
}
