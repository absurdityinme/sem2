package org.example.integrals;

public class Summator implements SumInterface {
    public volatile double sumAll = 0;

    public void addSum(double partValue) {
        synchronized (this) {
            sumAll += partValue;
        }
    }

    public double getSum() {
        return sumAll;
    }
}
