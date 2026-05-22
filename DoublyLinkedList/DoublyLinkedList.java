package DoublyLinkedList;

public class DoublyLinkedList {
    private class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) { this.value = value; }
    }
    
    private Node head;
    private Node tail;
    
    public void insertLast(int value) {
        // add to the back
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    
    public void deleteFirst() {
        // remove from front
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    
    public void display() {
        // walk forward and print
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
