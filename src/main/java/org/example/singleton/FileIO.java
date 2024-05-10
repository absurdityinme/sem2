package org.example.singleton;

import java.io.*;

public class FileIO {
    private static FileIO instance;
    private static File file = new File("singletonTask.txt");

    private FileIO() {}
    public static FileIO getInstance() {
        if (instance == null) {
            synchronized (FileIO.class) {
                if (instance == null) instance = new FileIO();
            }
        }
        return instance;
    }
    public synchronized void write(String string) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, true);
        for (int i = 0; i < string.length(); ++i) {
            fos.write(string.charAt(i));
        }
        fos.close();
    }

    public void read() throws IOException {
        FileInputStream fin = new FileInputStream(file);
        int IByte;
        while ((IByte = fin.read()) != -1) {
            System.out.print((char) IByte);
        }
    }
}
