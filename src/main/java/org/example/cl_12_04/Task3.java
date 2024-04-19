package org.example.cl_12_04;
/*
создать файл в формате:
1-е 4 байта - число N (длина сообщения в байтах)
следующие N байтов - сообщение
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("forTask3.txt");
            int iByte;
            int count = 0;
            while ((iByte = fin.read()) != -1) {
                count++;
            }
            FileOutputStream fos = new FileOutputStream("forTask4.txt");
            fos.write((count + "").getBytes());
            fin = new FileInputStream("forTask3.txt");
            while ((iByte = fin.read()) != -1) {
                fos.write((char) iByte);
            }
            fin.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
