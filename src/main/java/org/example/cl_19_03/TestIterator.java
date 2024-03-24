package org.example.cl_19_03;

import org.example.cl_17_02.Set;
import org.example.smth.EmptyElementException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class TestIterator {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        Iterator<String> iterator = list.iterator();
////        while (iterator.hasNext()) {
////           System.out.println(iterator.next());
////        }
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        iterator.remove();
//        iterator.remove();

        Set<String> set = new Set<>();
        try {
            set.add("a");
            set.add("b");
            set.add("c");
            set.add("d");
        }
        catch (EmptyElementException a) {
            System.out.println(a.getMessage());
        }

        Iterator<String> iterator = set.iterator();
//        System.out.println();
//        iterator.forEachRemaining(new Printer());
//        iterator = set.iterator();
//        System.out.println(iterator.next());

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
    }
    public static class Printer implements Consumer<String> {
        public void accept(String s){
            System.out.println(s);
        }
    }
}
