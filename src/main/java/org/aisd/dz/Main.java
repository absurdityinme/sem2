package org.aisd.dz;

public class Main {
    public static void main(String[] args) {
        String s1 = "7 2 3 * + 4 +";    // 7 + 2*3 + 4 = 17
        String s2 = "10 3 5 * 16 4 - / + "; // 10 + 3 * 5 / (16 - 4) = 11.25
        PostfixResulting p = new PostfixResulting();
        try {
            System.out.println(p.convert(s1));
            System.out.println(p.convert(s2));
        }
        catch (Exception a) {
            System.out.println(a.getMessage());
        }
    }
}
