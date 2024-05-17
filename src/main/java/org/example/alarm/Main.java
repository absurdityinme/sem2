package org.example.alarm;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Alarm alarm = new Alarm(new File("alarm.txt"), new File("signal.wav"));
        alarm.start();
    }
}