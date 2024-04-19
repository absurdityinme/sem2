package org.example.dz_13_03;
// прочитать файл и записать как массив адресов

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream("data-1712124662054.csv"), StandardCharsets.UTF_8);
        Map<String, String> map = new HashMap<>();

        while (true) {
            StringBuilder key = new StringBuilder();
            StringBuilder value = new StringBuilder();
            int iByte = in.read();
            if (iByte != -1) {
                do {
                    key.append((char) iByte);
                    iByte = in.read();
                }
                while (iByte != (int) ',');
            }
            else break;
            iByte = in.read();
            if (iByte != -1) {
                do {
                    iByte = in.read();
                    value.append((char) iByte);
                }
                while (iByte != (int) '\n');
            }
            else break;
            map.put(key.deleteCharAt(key.length()-1).toString(), value.deleteCharAt(value.length() - 1).toString());
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
