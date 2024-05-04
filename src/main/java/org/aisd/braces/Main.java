package org.aisd.braces;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String result = new String(Files.readAllBytes(Paths.get("transport.json")), StandardCharsets.UTF_8);
        System.out.println(check(result));
    }
    public static boolean check(String s) {
        int countOfBeauty = 0;
        int countOfQuadro = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '{') countOfBeauty++;
            else if (s.charAt(i) == '[') countOfQuadro++;
            else if (s.charAt(i) == '}') countOfBeauty--;
            else if (s.charAt(i) == ']') countOfQuadro--;
            if (countOfQuadro < 0 || countOfBeauty < 0) return false;
        }
        return countOfBeauty == 0 || countOfQuadro == 0;

    }
}
