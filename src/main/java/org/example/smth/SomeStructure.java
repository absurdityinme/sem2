package org.example.smth;

// однотипные элементы Object
// по позиции ( 0 .. )

import org.example.smth.EmptyElementException;

public interface SomeStructure <T> {
    void add(T e) throws EmptyElementException;
    void delete(int index) throws IndexOutOfBoundsException;
    T pop();
    T get(int index) throws IndexOutOfBoundsException;
    // count of elements
    int size();
}
