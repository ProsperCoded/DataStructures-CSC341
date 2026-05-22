package SinglyLinkedList;
import java.util.ArrayList;

public class LinkedList {
  private Node head;
  private Node tail;
  public int size;
  LinkedList(){
    // start with empty list
    this.head = null;
    this.tail = null;
  }
  public void addFirst(Integer value){
    // push to front
    Node node  = new Node(value);
    if(this.head==null){
      this.head = node;
      this.tail = node;
    }else{
      node.addNext(this.head);
      this.head = node;
    }
    this.size++;
  }
  public void addLast(Integer value){
    // push to end
    Node node  = new Node(value);
    if(this.head == null){
      this.head = node;
      this.tail = node;
    }else{
      this.tail.addNext(node);
      this.tail = node;
    }
    this.size++;
  }
  public void deleteFirst(){
    // remove from front
   if(this.isEmpty()) return;
    var reference  = this.head;
    // ? Previous head will be removed by default 
    this.head = this.head.next;
    // remove deleted node pointer to head, so it is garbage collected  
    reference.next = null;
    this.size--;
  }
  public void deleteLast(){
    // walk to the end (making list easier to tranverse)
    Node currentNode = head;
    Node secondToLast = null;
    while(currentNode!= null){
      if(currentNode.next.next==null){
       secondToLast = currentNode;
       System.out.println("Second to Last: "+secondToLast.value);
      //  * remove pointer last element 
        currentNode.addNext(null);
        break;
      }

      currentNode = currentNode.next;
      this.size--;
    }
    // * point to second to last element as the new tail
    this.tail = secondToLast;
  }

  public boolean contains(Integer value){
    // reuse indexOf so we don't repeat logic
    return this.indexOf(value) != -1;
  }
  public Integer indexOf(Integer value){
    // linear scan
    var currentNode = this.head;
    Integer trackIndex = 0;
    while(currentNode != null){
      if(currentNode.value == value){
        return trackIndex;
      }
      currentNode = currentNode.next;
      trackIndex++;
    }
    return -1;
  }
  public boolean isEmpty(){
    // empty if no head
    return this.head==null;
  }
  public boolean isSingleElement(){
    // head equals tail means one node
    return this.head == this.tail;
  }
  public void reverse(){

    if(isEmpty() || isSingleElement()){
      // ? No need to reverse an empty or single element list
      return;
    }
    // * track the previous node 
    Node p = null;

    // * track the next node
    Node n = this.head;

    while (n!=null){
      // * temp variable for switching pointers
      var t = n;
      n = n.next;
      t.next = p;
      p = t;
    }
    // * switch head and tail respectively 
    var temp = this.head;
    this.head = this.tail;
    this.tail = temp;
  }
  public int getKthFromTheEnd(int k){
    // two pointer trick from class
    // ensure k isn't out of range 
    if(this.size< k) throw new IndexOutOfBoundsException();
    // ? going to apply two pointer method 
    var p1 = this.head;
    var p2 = this.head;
    // * move p2 k-1 distance from p1 
    for (int i = 1; i < k; i++) {
      p2 = p2.next;
    }    
    // move both pointers to  the end of list, maintaining their distance 
    while(p2.next!= null){
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1.value;
  }
  public ArrayList<Integer> all(){
    // dump values into array list
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Node currentNode = head;
    while(currentNode!= null){
      arr.add(currentNode.value);
      currentNode = currentNode.next;
    }
    return arr;
  }
}
