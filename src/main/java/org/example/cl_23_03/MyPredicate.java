package org.example.cl_23_03;

import java.util.function.Predicate;

public class MyPredicate {
    public static void main(String[] args) {
        Predicate<Integer> predicate = new TestPredicate();
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(17));
    }

    public static class TestPredicate implements Predicate<Integer> {
        public boolean test(Integer integer) {
            for (int i = 2; i * i < integer; ++i) {
                if (integer % i == 0) return false;
            }
            return true;
        }
        public Predicate<Integer> negate() {
            return (new Predicate<Integer>() {
                public boolean test(Integer integer) {
                    for (int i = 2; i * i < integer; ++i) {
                        if (integer % i == 0) return true;
                    }
                    return false;
                }
            });
        }
    }
}
