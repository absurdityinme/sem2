package org.example.cl_30_03;

import java.util.Comparator;

public class CompareExample {
    private static Integer a = 100;
    private static Integer b = 100;
    public static void method(Comparator<Integer> comparator) {
        if (comparator.compare(a, b) > 0) System.out.println(">");
        else if (comparator.compare(a, b) < 0) System.out.println("<");
        else System.out.println("=");

    }
    public static void main(String[] args) {
        method(new IntCompare());
        method(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        method((x,y) -> {return x - y;});
        method((x,y) -> x - y);

    }
    private static class IntCompare implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
