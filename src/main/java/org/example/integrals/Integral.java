package org.example.integrals;

import lombok.Getter;

public class Integral extends Thread {
    @Getter
    private double sum;
    private int N = 1000;
    private double a;
    private double b;
    private SumInterface summator;
    Integral(double a, double b, SumInterface summator) {
        this.a = a;
        this.b = b;
        this.summator = summator;
    }

    private double func(double t) {
        return Math.sin(Math.exp(t));
    }

    @Override
    public void run() {
        double delta = (b - a) / N;
        for (int i = 0; i < N; ++i) {
            sum += (func(a + delta * i) + func(a + delta * (i + 1))) / 2 * delta;
        }
        if (summator != null) summator.addSum(sum);
    }

}
