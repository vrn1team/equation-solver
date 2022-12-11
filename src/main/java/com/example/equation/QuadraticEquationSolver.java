package com.example.equation;


public class QuadraticEquationSolver {

    public static final int PRECISION = -10; // epsilon power, means 10^PRECISION

    public double[] solve(double a, double b, double c) {

        checkIfNumbers(a, b, c);

        if (isZero(a)) {
            throw new IllegalArgumentException("A must not be equal zero");
        }

        double[] result = null;
        double discriminant = b * b - 4 * a * c;

        if (isZero(discriminant)) {
            double solution = -b / (2 * a);
            result = new double[]{solution};
        } else if (aboveZero(discriminant)) {
            double solution1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double solution2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            result = new double[]{solution1, solution2};
        } else {
            result = new double[]{};
        }
        return result;
    }

    private void checkIfNumbers(double a, double b, double c) {
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("A must be a finite number");
        }

        if (Double.isNaN(b) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("B must be a finite number");
        }

        if (Double.isNaN(c) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("C must be a finite number");
        }
    }

    private boolean isZero(double a) {
        return Double.compare(Math.abs(a - 0), Math.pow(10, PRECISION)) < 0;
    }

    private boolean aboveZero(double a) {
        return Double.compare(a - 0, Math.pow(10, PRECISION)) > 0;
    }
}
