package org.example.cl_30_03;

import org.example.cl_23_03.MyPredicate;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {
    public static String s = "hello";

    public static void accept(Consumer<String> consumer) {
        consumer.accept(s);
    }
    public static void main(String[] args) {
        accept(new MyConsumer());
        accept(new Consumer<String>() {
            public void accept (String s){
                System.out.println(s);
            }
        });
        accept((str) -> {System.out.println(str);} );
        accept((str) -> System.out.println(str) );
        accept(System.out::println);

    }
    static class MyConsumer implements Consumer<String> {
        public void accept(String s) {
            System.out.println(s);
        }
    }
}
