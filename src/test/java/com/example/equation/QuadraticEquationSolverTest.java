package com.example.equation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.example.equation.QuadraticEquationSolver.PRECISION;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadraticEquationSolverTest {
    QuadraticEquationSolver cut = new QuadraticEquationSolver();

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

    @Test
    @DisplayName("Equation x^2-1 = 0 has 2 roots, 1 and -1")
    void testEquationHasTwoRoots() {
        // arrange
        double a = 1;
        double b = 0;
        double c = -1;
        // act
        var result = cut.solve(a, b, c);
        // assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new double[]{-1, 1}, result);
    }

    @Test
    @DisplayName("Equation x^2+2x+1 = 0 has 1 root, -1")
    void testEquationHasOneRoot() {
        // arrange
        double a = 1;
        double b = 2 + Math.pow(10, PRECISION - 1);
        double c = 1;
        // act
        var result = cut.solve(a, b, c);
        // assert
        var expectedRootVal = -b / (2 * a);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertArrayEquals(new double[]{expectedRootVal}, result);
    }

    @Test
    @DisplayName("Exception when coefficient a is equal to 0")
    void testIfCoefAIsZeroThenException() {
        // arrange
        double a = 0;
        double b = 1;
        double c = 1;
        // act
        final Executable executable = () -> cut.solve(a, b, c);
        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}