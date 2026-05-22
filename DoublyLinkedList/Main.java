package DoublyLinkedList;
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList ds = new DoublyLinkedList();
        ds.insertLast(10);
        ds.insertLast(20);
        System.out.print("DoublyLinkedList: ");
        ds.display(); // 10 <-> 20 <-> null
        ds.deleteFirst();
        System.out.print("DoublyLinkedList after deleteFirst: ");
        ds.display(); // 20 <-> null
    }
}
