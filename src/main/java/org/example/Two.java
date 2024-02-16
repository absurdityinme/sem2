package org.example;

public class Two implements SomeStructure {
    Node head;
    private int size;
    Two() {};
    Two(int[] array) {
        head = new Node(array[0]);
        Node temp, tempPrev = head;
        for (int i = 1; i < array.length; ++i) {
            temp = new Node(array[i]);
            temp.previous = tempPrev;
            tempPrev.next = temp;
            tempPrev = temp;
        }
        size = array.length;
    }
    public int findFirst(Integer e) {
        Node current = head;
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
    public int findLast(Integer e) {
        Node current = head;
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
        Node current = head;
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
    public void output() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void add(Integer e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException("Empty elem !");
        Node e1 = new Node(e);
        if (head == null) {
            head = e1;
        }
        else {
            Node current = head;
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
        Node e = head;
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

    public Integer pop() {
        Node e = head;
        while (e.next != null) {
            e = e.next;
        }
        Integer re = e.value;
        e.previous.next = null;
        e = null;
        size--;
        return re;
    }

    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index + 1 > size) throw new IndexOutOfBoundsException("no more bounds");
        Node e = head;
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
