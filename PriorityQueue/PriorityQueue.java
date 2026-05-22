package PriorityQueue;

import java.util.Arrays;

// My solution
public class PriorityQueue {
  int[] elements = null;
  int size;
  // works by index
  int count = -1;

  public PriorityQueue(int s) {
    elements = new int[s + 1];
    this.size = s;
  }

  public void insert(int value) {
    if (count == size) {
      throw new IllegalArgumentException();
    }
    if (count == -1) {
      elements[0] = value;
      count = 0;
      return;
    }
    for (int i = count; i >= 0; i--) {
      if (elements[i] > value) {
        var temp = value;
        elements[i + 1] = elements[i];
        elements[i] = temp;
      } else {
        elements[i + 1] = value;
        break;
      }
    }
    // ? Putting it here cause sometimes it doesn't reach the else block, because
    // index can be -1, it such case the switched element is at the right position
    count++;
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }
}
