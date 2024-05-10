package org.example.singleton;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIO.getInstance().write("InsertionSort\n");
        FileIO.getInstance().read();
        System.out.println();
        FileIO.getInstance().write("MergeSort\n");
        FileIO.getInstance().read();
    }
}
