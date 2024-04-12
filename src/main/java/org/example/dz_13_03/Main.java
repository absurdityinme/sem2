package org.example.dz_13_03;
// прочитать файл и записать как массив адресов

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data-1712124662054.csv")));
        Map<String, String> map = new HashMap<>();
        do {
            String[] strings = reader.readLine().split(",");
            map.put(strings[0], strings[1]);
        }
        while (reader.ready());
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
