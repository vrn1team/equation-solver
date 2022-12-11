package com.example.equation;


public class QuadraticEquation {

    public double[] solve(double a, double b, double c) {
        double[] result = null;
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            result = new double[]{};
        } else if (discriminant > 0) {
            double solution1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double solution2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            result = new double[]{solution1, solution2};
        }
        return result;
    }
}
