package org.example.cl_17_02;

import org.example.EmptyElementException;
import org.example.Node;

public class Set<T> {
    Node<T> head;
    int size;
    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty elem !");
        if (contains(e)) return;
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
    public boolean contains(T e) {
        Node<T> current = head;
        while (current.next != null) {
            if (current.value.equals(e)) return true;
        }
        return false;
    }
}
