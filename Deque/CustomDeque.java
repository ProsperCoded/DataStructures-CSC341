package Deque;

public class CustomDeque {
    private class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) { this.value = value; }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public CustomDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) throw new IllegalStateException();
        int val = head.value;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    public int removeLast() {
        if (isEmpty()) throw new IllegalStateException();
        int val = tail.value;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
