package PriorityQueue;

// * Insertion  - O(n)
// * Deletion   - O(1)

// This solution is from tutorial 
public class PriorityQueue2 {
  int[] items = new int[5];
  int count;

  public void add(int item) {
    if (count == items.length) {
      throw new IllegalArgumentException();
    }
    var position = shiftItemToInsert(item);
    items[position] = item;
  }

  public int shiftItemToInsert(int item) {
    int i;
    for (i = count - 1; i >= 0; i--) {
      if (items[i] > item) {
        items[i + 1] = items[i];
      } else
        break;
    }
    return i + 1;
  }
}
