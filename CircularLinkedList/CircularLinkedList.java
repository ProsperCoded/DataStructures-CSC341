package CircularLinkedList;

public class CircularLinkedList {
    private class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }
    
    private Node head;
    private Node tail;
    
    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head; // Circular link
        }
    }
    
    public void delete(int value) {
        if (head == null) return;
        
        Node current = head;
        Node previous = tail;
        
        do {
            if (current.value == value) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }
}
