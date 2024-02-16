package org.example;

public class One implements SomeStructure {
    private Integer[] array;
    private int size;
    private int capacity;
    One(int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
    }
    public void add(Integer e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty element !");
        if (size == capacity) {
            Integer[] arrayNew = new Integer[capacity*2];
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
    public Integer pop() {
        Integer re = array[--size];
        array[size] = null;
        return re;
    }

    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        return array[index];
    }
    public int size() { return size; }
}
