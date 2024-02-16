package org.aisd.dz_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        gistogramm(s);
    }

    public static void gistogramm(String s) {
        int[] nun = new int[127];
        for (int i = 0; i < s.length(); ++i) {
            nun[s.charAt(i)]++;
        }
        int max = nun[0];
        int index = -1;
        for (int i = 1; i < nun.length; ++i) {
            if (nun[i] > nun[i-1]) {
                max = nun[i];
                index = i;
            }
        }
        System.out.println((char) index);
    }
}
