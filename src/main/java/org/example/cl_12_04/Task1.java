package org.example.cl_12_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Написать программу, объединяющую 2 файла в один.
Программа должна принимать 3 параметра командной строки file1 file2 fileResult
(Использовать FileInputStream и FileOutputStream)
 */
public class Task1 {
    public static void main(String[] args) throws IOException{
        FileInputStream fin1 = new FileInputStream(args[0]);
        FileInputStream fin2 = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        int iByte = 0;
        while (iByte != -1) {
            if ((iByte = fin1.read()) != -1) {
                fos.write(iByte);
            }
            else if ((iByte = fin2.read()) != -1) {
                fos.write(iByte);
            }
        }
        fin1.close();
        fin2.close();
        fos.close();
    }
}
