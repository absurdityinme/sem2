package org.example.cl_12_04;
/*
Прочитать файл посимвольно, и вывести таблицу:
буква - количество вхождений (учитывать только имеющиеся в наличие символы)
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<Character, Integer> dict = new HashMap<>();
        try {
            FileInputStream fin = new FileInputStream("forTask2.txt");
            int iByte;
            int diff;
            int start = 'A';
            int end = 'Z';
            while ((iByte = fin.read()) != -1) {
                Integer i = dict.get((char) iByte);
                if (iByte >= start && iByte <= end) diff = 'a' - 'A';
                else diff = 0;
                if (i != null) dict.put((char) (iByte + diff), ++i);
                else dict.put((char) (iByte + diff), 1);
            }
            dict.forEach((k,v) -> System.out.println(k + ": " + v));
            fin.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
