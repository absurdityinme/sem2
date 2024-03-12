package org.example.cl_02_03;

public class Main {
    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        System.out.println(map.put("Zero", 0));
        System.out.println(map.put("First", 1));
        System.out.println(map.put("Second", 2));
//        System.out.println(map.get("Zero"));
//        System.out.println(map.put("Second", 10));
//        System.out.println(map.get("Second"));
        System.out.println(map.remove("First"));
        System.out.println(map.keySet());
    }
}
