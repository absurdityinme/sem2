package org.example.alarm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Alarm {
    File file;
    List<String> list;
    File sound;

    public Alarm(File file, File sound) {
        this.file = file;
        this.sound = sound;
    }

    public void setAlarm(String timeString) throws ParseException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                PlayWAV.playWavFromFile(sound);
            }
        };
        Timer timer = new Timer();
        Date time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(timeString);
        timer.schedule(task, time);
    }

    private void read() throws IOException {
        FileInputStream fin = new FileInputStream(file);
        list = new ArrayList<>();
        int IByte;
        while ((IByte = fin.read()) != -1) {
            String string = "";
            while (IByte != (int) '\n' && IByte != -1) {
                string += (char) IByte;
                IByte = fin.read();
            }
            list.add(string);
        }
    }

    public void start() throws IOException, ParseException {
        read();
        list.forEach((str) -> {
            try {
                setAlarm(str);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
    }
}