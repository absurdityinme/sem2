package org.example.deadlock;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Painting {
    private final String name;
    @Setter
    private Museum museum;
    public Painting(String name, Museum museum) {
        this.name = name;
        this.museum = museum;
    }
}
