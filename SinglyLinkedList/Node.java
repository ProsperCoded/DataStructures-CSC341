package SinglyLinkedList;
public class Node {
  public Integer value;
  public Node next;

  public Node(Integer value) {
    this.value = value;
  }
  public void addNext(Node node) {
    this.next = node;
  }
}
