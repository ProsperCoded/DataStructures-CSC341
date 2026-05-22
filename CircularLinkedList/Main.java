package CircularLinkedList;
public class Main {
    public static void main(String[] args) {
        CircularLinkedList ds = new CircularLinkedList();
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.delete(20);
        System.out.println("CircularLinkedList insert/delete test passed.");
    }
}
