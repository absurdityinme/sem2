package org.example.cl_20_04_TESTS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formateDate(Date data) throws NullPointerException {
        return new SimpleDateFormat("dd.MM.yyyy").format(data);
    }
}
