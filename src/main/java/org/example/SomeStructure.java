package org.example;

// однотипные элементы Integer
// по позиции ( 0 .. )

public interface SomeStructure {
    void add(Integer e) throws EmptyElementException;
    void delete(int index) throws IndexOutOfBoundsException;
    Integer pop();
    Integer get(int index) throws IndexOutOfBoundsException;
    // count of elements
    int size();
}
