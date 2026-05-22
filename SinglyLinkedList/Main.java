package SinglyLinkedList;
// package SinglyLinkedList;


public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    var value = list.getKthFromTheEnd(3);
    System.out.println(value);
  }
}
