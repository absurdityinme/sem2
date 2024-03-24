package org.example.cl_23_03;

import org.example.cl_17_02.Set;
import org.example.smth.EmptyElementException;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new Set<>();
        try {
            set.add("jojo");
            set.add("jojo");
            set.add("fourth");
        }
        catch (EmptyElementException a) {
            System.out.println(a.getMessage());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
