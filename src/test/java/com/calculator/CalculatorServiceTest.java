
package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAddition() {
        assertEquals(30.0, calculatorService.add(10, 20));
    }

    @Test
    void testSubtraction() {
        assertEquals(10.0, calculatorService.subtract(20, 10));
    }

    @Test
    void testMultiplication() {
        assertEquals(200.0, calculatorService.multiply(20, 10));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculatorService.divide(20, 10));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculatorService.divide(10, 0)
        );
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-10.0, calculatorService.add(-20, 10));
    }
}
