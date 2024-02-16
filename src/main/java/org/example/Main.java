package org.example;

public class Main {
    public static void main(String[] args) {
//        One a = new One(4);
//        try {
//            a.add(10);
//            a.add(1);
//            a.add(10);
//            a.add(1);
//            a.add(10);
//            a.add(1);
//            a.add(0);
//        }
//        catch (EmptyElementException b) {
//            System.out.println(b.getMessage());
//        }
//        System.out.println(a.get(0) + " " + a.get(6));
//        a.delete(0);
//        System.out.println(a.get(0));
//
//        Two array2 = new Two();
//        try {
//            array2.add(10);
//            array2.add(2);
//            array2.add(3);
//        }
//        catch (EmptyElementException b) {
//            System.out.println(b.getMessage());
//        }
//        System.out.println("size = " + array2.size());
//        try {
//            System.out.println(array2.get(0));
//            System.out.println(array2.get(1));
//            System.out.println(array2.get(2));
//        }
//        catch (IndexOutOfBoundsException c) {
//            System.out.println(c.getMessage());
//        }
//        array2.delete(1);
//        array2.output();
//
//        int[] ar = new int[]{9, 4, 5};
//        Two arr = new Two(ar);
//        arr.output();
        int[] ar = new int[] {9, 3, 4, 3, 4, 0, 4, -2};
        Two a = new Two(ar);
        a.output();
        a.deleteAllSimilar();
        a.output();
    }
}