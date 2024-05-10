package org.example.deadlock;

import lombok.Getter;

import java.util.List;

public class Museum {
    @Getter
    private final String name;
    public Museum(String name) {
        this.name = name;
    }
}
