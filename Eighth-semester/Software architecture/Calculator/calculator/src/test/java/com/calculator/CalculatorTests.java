package com.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test
    public void testSuma() {
        assertEquals(4, calculator.Suma(2, 2), 0.1);
    }

    @Test
    public void testResta() {
        assertEquals(10, calculator.Resta(34, 24), 0.1);
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(14, calculator.Multiplicar(2, 7), 0.1);
    }

    @Test
    public void testDivision() {
        assertEquals(4, calculator.Dividir(8, 2), 0.1);
    }
}
