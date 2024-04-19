package org.example.cl_12_04;
/*
Прочитать сообщение из созданного файла и вывести его длину, прочитанную из первых 4 байтов
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) {
        try {
            InputStreamReader fin = new InputStreamReader(new FileInputStream("forTask4.txt"), "UTF8");
            // FileInputStream fin = new FileInputStream("forTask4.txt");
            StringBuilder len = new StringBuilder();
            int iBytes;
            for (int i = 0; i < 4; ++i) {
                len.append((char) fin.read());
            }
            System.out.println("length of message in bytes: " + len);
            while ((iBytes = fin.read()) != -1) {
                System.out.print((char) iBytes);
            }
            fin.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
