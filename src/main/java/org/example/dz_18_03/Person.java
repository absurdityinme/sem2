package org.example.dz_18_03;

public class Person {
    public String name;
    boolean alive;
    Person(String name) {
        this.name = name;
        alive = true;
    }
    public void kill() {
        alive = false;
    }
    public String toString() {
        return "i'm " + name;
    }
}
