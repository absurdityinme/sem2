package org.example;

public class One<T> implements SomeStructure<T> {
    private Object[] array;
    private int size;
    private int capacity;
    One(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }
    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty element !");
        if (size == capacity) {
            Object[] arrayNew = new Object[capacity*2];
            capacity *= 2;
            System.arraycopy(array, 0, arrayNew, 0, array.length);
            array = arrayNew;
        }
        array[size++] = e;
    }
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size--; ++i) {
            array[i] = array[i+1];
        }
        array[size + 1] = null;
    }
    public T pop() {
        Object re = array[--size];
        array[size] = null;
        return (T) re;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }
    public int size() { return size; }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; ++i) {
            s = s + array[i] + " ";
        }
        return s;
    }
}
