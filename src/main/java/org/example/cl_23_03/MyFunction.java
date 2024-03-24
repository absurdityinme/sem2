package org.example.cl_23_03;

import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {
        Function<Double, Double> funcTest = a -> Math.sqrt(a);
        System.out.println(funcTest.apply(16d));
    }

    public static class TestFunction implements Function<Double, Double> {
        public Double apply(Double param) {
            return Math.sqrt(param);
        }
    }
}
