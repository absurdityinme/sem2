package org.example.building;

import lombok.Getter;

@Getter
public class Work implements Runnable {
    private final String name;
    private final int days;
     boolean wasStarted;
    Work(String name, int days) {
        this.name = name;
        this.days = days;
    }
    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            Thread.sleep(1000L * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wasStarted = true;
        System.out.println("End " + name);
    }
}
