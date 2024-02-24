package org.example.cl_17_02;

import org.example.EmptyElementException;
import org.example.Node;

public class Set<T> {
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
}
