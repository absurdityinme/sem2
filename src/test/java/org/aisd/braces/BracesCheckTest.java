package org.aisd.braces;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BracesCheckTest {
    @Test
    public void correctBracesTest() throws IOException, NullPointerException, NotTextFileException {
        int check = BracesCheck.correctBraces("transport.json");
        Assert.assertEquals(0, check);
    }

    @Test
    public void wrongBracesTest() throws IOException, NullPointerException, NotTextFileException {
        int check = BracesCheck.correctBraces("transportBroken.json");
        Assert.assertNotEquals(0, check);
    }

    @Test(expected = NullPointerException.class)
    public void NullBracesTest() throws IOException, NullPointerException, NotTextFileException {
        BracesCheck.correctBraces(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void NoFileBracesTest() throws IOException, NullPointerException, NotTextFileException {
        BracesCheck.correctBraces("AgustD.txt");
    }

    @Test(expected = NotTextFileException.class)
    public void NoTextFileBracesTest() throws IOException, NullPointerException, NotTextFileException {
        BracesCheck.correctBraces("transportBinary.json");
    }
}
