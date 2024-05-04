package org.example.integrals;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Summator summator = new Summator();
        double a = 0;
        double b = 1;
        int countOfThreads = Runtime.getRuntime().availableProcessors();
        double delta = (b - a) / countOfThreads;

        Integral oneIntegralThread = new Integral(a, b, null);
        long start1 = System.nanoTime();
        oneIntegralThread.start();
        long end1 = System.nanoTime();

        List<Integral> integralList = new ArrayList<>();
        for (int i = 0; i < countOfThreads; ++i) {
            integralList.add(new Integral(a + delta * i, a + delta * (i + 1), summator));
        }
        long start2 = System.nanoTime();
        integralList.forEach(Thread::start);
        double sum = integralList.stream().mapToDouble(Integral::getSum).sum();
        long end2 = System.nanoTime();

        System.out.println("sum: " + oneIntegralThread.getSum());
        System.out.println("time if there's 1 thread: " + (end1 - start1));
        System.out.println();

        System.out.println("summator: " + summator.getSum());
        System.out.println("sum: " + sum);
        System.out.println("time if there's " + countOfThreads + " threads: " + (end2 - start2));
    }
}
