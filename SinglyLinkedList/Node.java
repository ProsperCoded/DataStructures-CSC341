package SinglyLinkedList;
public class Node {
  public Integer value;
  public Node next;

  public Node(Integer value) {
    // store the data
    this.value = value;
  }
  public void addNext(Node node) {
    // point to the next node
    this.next = node;
  }
}
