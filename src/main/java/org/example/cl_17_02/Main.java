package org.example.cl_17_02;

import org.example.smth.EmptyElementException;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
        }
        catch (EmptyElementException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        Set<String> set = new Set<>();
        try {
            set.add("first");
            set.add("second");
            set.add("third");
            set.add("fourth");
        }
        catch (EmptyElementException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(set);
        System.out.println(set.contains("jojo"));
        try {
            set.add("jojo");
            set.add("jojo");
            set.add("fourth");
        }
        catch (EmptyElementException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(set);
        System.out.println(set.contains("jojo"));
        set.delete(0);
        System.out.println(set);
    }
}
