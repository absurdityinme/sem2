package org.example;

public class Two<T> implements SomeStructure<T> {
    Node<T> head;
    private int size;
    Two() {};
    Two(T[] array) {
        head = new Node<T>(array[0]);
        Node<T> temp, tempPrev = head;
        for (int i = 1; i < array.length; ++i) {
            temp = new Node<T>(array[i]);
            temp.previous = tempPrev;
            tempPrev.next = temp;
            tempPrev = temp;
        }
        size = array.length;
    }
    public int findFirst(T e) {
        Node<T> current = head;
        int index = 0;
        while (!current.value.equals(e)) {
            current = current.next;
            index++;
            if (current.next == null && !current.value.equals(e)) {
                index = -1;
                break;
            }
        }
        return index;
    }
    public int findLast(T e) {
        Node<T> current = head;
        int index = 0;
        int IND = -1;
        while (current.next != null) {
            if (current.value.equals(e)) IND = index;
            current = current.next;
            index++;
            if (current.next == null && !current.value.equals(e) && IND != -1) {
                break;
            }
        }
        return IND;
    }

    public void deleteAllSimilar() {
        Node<T> current = head;
        boolean flag = false;
        while (current.next != null) {
            if (findFirst(current.value) != findLast(current.value)) {
                delete(findFirst(current.value));
                flag = true;
                continue;
            }
            if (flag) delete(findFirst(current.value));
            current = current.next;
            flag = false;
        }

    }
    public String toString() {
        Node<T> current = head;
        String s = "";
        while (current != null) {
            s = s + current.value + " ";
            current = current.next;
        }
        return s;
    }
    public void add(T e) throws EmptyElementException {
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
    public void delete(int index) throws IndexOutOfBoundsException {
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

    public T get(int index) throws IndexOutOfBoundsException {
        if (index + 1 > size) throw new IndexOutOfBoundsException("no more bounds");
        Node<T> e = head;
        int count = 0;
        while (count != index) {
            e = e.next;
            count++;
        }
        return e.value;
    }

    public int size() {
        return size;
    }
}
