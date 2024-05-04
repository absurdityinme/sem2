package org.example.cl_20_04_TESTS;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilTest {
    @Test
    public void testFormateDate() {
        String testStringDate = "21.04.2024";
        Date testData = null;
        try {
            testData = new SimpleDateFormat("dd.MM.yyyy").parse(testStringDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        if (!testStringDate.equals(DateUtil.formateDate(new Date()))) {
            Assert.fail("sorry !");
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {
        DateUtil.formateDate(null);
    }
}
