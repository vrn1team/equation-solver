package com.example.equation;


public class QuadraticEquation {

    public double[] solve(double a, double b, double c) {
        double[] result = null;
        double d = b * b - 4 * a * c;
        if (d < 0) {
            result = new double[]{};
        }
        return result;
    }
}
