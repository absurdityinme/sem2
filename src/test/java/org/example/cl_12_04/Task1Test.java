package org.example.cl_12_04;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;

public class Task1Test {
    @Test
    public void testMergeFiles() throws IOException {
        Task1.main(new String[]{"file1.txt", "file2.txt", "fileResult.txt"});
        InputStream in1 = new FileInputStream("file1.txt");
        InputStream in2 = new FileInputStream("file2.txt");
        InputStream in = new java.io.SequenceInputStream(in1, in2);
        Assert.assertArrayEquals(new FileInputStream("fileResult.txt").readAllBytes(), in.readAllBytes());
    }

    @Test
    public void testMergeFilesWrong() throws IOException {
        Task1.main(new String[]{"file1.txt", "file2.txt", "fileResult.txt"});
        InputStream in1 = new FileInputStream("file1.txt");
        InputStream in2 = new FileInputStream("file1.txt");
        InputStream in = new java.io.SequenceInputStream(in1, in2);
        Assert.assertNotEquals(new FileInputStream("fileResult.txt").readAllBytes(), in.readAllBytes());
    }

    @Test(expected = IOException.class)
    public void testIOException() throws IOException{
        Task1.main(new String[]{"", "file2.txt", "fileResult.txt"});
    }
}
