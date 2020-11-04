package me.codeenzyme.simplecalculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final double delta = 0.000001;

    @Test
    public void addInt_isCorrect() {
        assertEquals(20, Calculator.add(11, 9));
    }

    @Test
    public void addDouble_isCorrect() {
        assertEquals(3.5, Calculator.add(2.0, 1.5), delta);
    }

    @Test
    public void subtractInt_isCorrect() {
        assertEquals(50, Calculator.subtract(100, 50));
    }

    @Test
    public void subtractDouble_isCorrect() {
        assertEquals(0.5, Calculator.subtract(2.0, 1.5), delta);
    }

    @Test
    public void multiplyInt_isCorrect() {
        assertEquals(30, Calculator.multiply(5, 6));
    }

    @Test
    public void multiplyDouble_isCorrect() {
        assertEquals(35.5, Calculator.multiply(7.1, 5.0), delta);
    }

    @Test
    public void divide_isCorrect() {
        assertEquals(7.1, Calculator.divide(35.5, 5.0), delta);
    }

    @Test
    public void divideByZero_isCorrect() {
        assertEquals(Double.POSITIVE_INFINITY, Calculator.divide(35.5, 0), delta);
    }

}
