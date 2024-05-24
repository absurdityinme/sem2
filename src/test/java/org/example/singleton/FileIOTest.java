package org.example.singleton;

import org.junit.Assert;
import org.junit.Test;

public class FileIOTest {
    @Test
    public void testIsClassSIngleton() {
        Assert.assertTrue(FileIO.getInstance() == FileIO.getInstance());
    }
}
