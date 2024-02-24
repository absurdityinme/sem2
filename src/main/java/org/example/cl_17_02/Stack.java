package org.example.cl_17_02;

import org.example.EmptyElementException;
import org.example.Node;

public class Stack<T> {
    Node<T> head;
    private int size;

    public void push(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty elem !");
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
    public T pop() {
        Node<T> e = head;
        while (e.next != null) {
            e = e.next;
        }
        T re = e.value;
        e.previous.next = null;
        size--;
        return re;
    }
    public int size() {
        return size;
    }
}
