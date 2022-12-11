package com.example.equation;


public class QuadraticEquation {

    private static final int PRECISION = -10; // epsilon power, means 10^PRECISION

    public double[] solve(double a, double b, double c) {

        if (equalDoubles(a, 0)) {
            throw new IllegalArgumentException("A must not be equal zero");
        }

        double[] result = null;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            result = new double[]{};
        } else if (discriminant > 0) {
            double solution1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double solution2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            result = new double[]{solution1, solution2};
        } else {
            double solution = -b / (2 * a);
            result = new double[]{solution};
        }
        return result;
    }

    private boolean equalDoubles(double a, double b) {
        return Double.compare(Math.abs(a - b), Math.pow(10, PRECISION)) < 0;
    }
}
