package org.example.cl_30_03;

import java.util.Comparator;
import java.util.function.Supplier;

public class SupplierExample {
    private static String s = "hello";
    public static void accept(Supplier<String> supplier) {
        System.out.println(supplier.get());

    }
    public static void main(String[] args) {
        accept(new TestSupplier());
        accept(new Supplier<String>() {
            public String get() {
                return s;
            }
        });
        accept(() -> {return s;});
        accept(() -> s);

    }
    private static class TestSupplier implements Supplier<String> {
        public String get() {
            return s;
        }
    }
}
