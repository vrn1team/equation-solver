package com.example.equation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuadraticEquationTest {
    QuadraticEquation cut = new QuadraticEquation();

    @Test
    @DisplayName("Equation x^2+1 = 0 has no roots")
    void testEquationHasNoRoots() {
        // arrange
        double a = 1;
        double b = 0;
        double c = 1;
        // act
        var result = cut.solve(a, b, c);
        // assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
}