package org.aisd.dz_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        gistogramm(s);

    }

    public static void gistogramm(String s) {
        long startTime = System.nanoTime();

        int[] nun = new int[127];
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ' && s.charAt(i) != '\n') nun[s.charAt(i)]++;
        }
        int max = 0;
        for (int i = 0; i < nun.length; ++i) {
            if (nun[i] > max) {
                max = nun[i];
            }
        }
        for (int i = 0; i < max; ++i) {
            for (int j = 0; j < nun.length; ++j) {
                if (nun[j] == 0) continue;
                else if (((max - nun[j]) <= i)) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < nun.length; ++i) {
            if (nun[i] != 0) System.out.print((char) i);
        }
        System.out.println();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("time: " + (double) totalTime / 1_000_000_000 + " sec");
    }
}
