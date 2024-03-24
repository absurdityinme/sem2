package org.example.cl_17_02;

import org.example.smth.EmptyElementException;
import org.example.smth.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T> {
    Node<T> head;
    int size;
    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty elem !");
        if (head != null && contains(e)) return;
        Node<T> e1 = new Node<>(e);
        if (head == null) {
            head = e1;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = e1;
            e1.previous = current;
        }
        size++;
    }
    public void delete(int index) {
        if (index + 1 > size) throw new IndexOutOfBoundsException();
        Node<T> e = head;
        int count = 0;
        while (count != index) {
            e = e.next;
            count++;
        }
        if (head == e && size != 1) {
            head = e.next;
            e.previous = null;
        }
        else if (head == e) head = null;
        else if (e.next == null) {
            e.previous.next = null;
            e = null;
        }
        else {
            e.previous.next = e.next;
            e.next.previous = e.previous;
            e = null;
        }
        size--;
    }
    public String toString() {
        String s = "";
        Node<T> current = head;
        while (current != null) {
            s = s + current.value + " ";
            current = current.next;
        }
        return s;
    }
    public boolean contains(T e) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(e)) return true;
            current = current.next;
        }
        return false;
    }
    public T get(int index) {
        Node<T> current = head;
        int ind = 0;
        while (current != null) {
            if (ind == index) return current.value;
            ind++;
            current = current.next;
        }
        return null;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        int place;
        int sizeBefore;
        boolean removeWas;
        boolean removeWasOnce; // if remove was ever called
        MyIterator() { sizeBefore = size; }
        public boolean hasNext() {
            return place < size;
        }
        public T next() {
            if (place == size) throw new NoSuchElementException();
            if ((sizeBefore > size && !removeWasOnce) || (sizeBefore < size)) throw new ConcurrentModificationException();
            removeWas = false;
            return get(place++);
        }
        public void remove() {
            if (place == 0 || removeWas) throw new IllegalStateException();
            removeWas = true;
            if (!removeWasOnce) removeWasOnce = true;
            delete(--place);
        }

    }
}
