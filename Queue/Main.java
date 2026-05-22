package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {

    var queue = new ArrayQueue(5);
    queue.enqueue(4);
    queue.enqueue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(7);
    // queue.enqueue(3);
    System.out.println(queue.toString());
  }

  public static LinkedList<Integer> reverse(Queue<Integer> queue) {
    LinkedList<Integer> store = new LinkedList<Integer>();
    while (!queue.isEmpty()) {
      var element = queue.remove();
      store.addFirst(element);
    }
    return store;
  }
}
