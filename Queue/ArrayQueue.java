package Queue;

import java.util.Arrays;

// Implementing array queue in a circular array pattern
public class ArrayQueue {
  int[] arr;
  int size;
  int f = 0;
  int r = 0;
  int count = 0;
  public ArrayQueue(int s){
    this.size = s;
    this.arr = new int[s];
  }
  public void enqueue(int value){
    if(isFull()){
      throw new IllegalArgumentException();
    }
    var index = r % size;
    this.arr[index] = value;
    count++;
    r++;
  }
  public int dequeue(){
    if(isEmpty()){
      throw new IllegalArgumentException();
    }
    var index = f % size;
    var value = arr[index];
    arr[index] = 0;
    f++;
    count--;
    return value;
  }
  public int peek(){
    return arr[f];
  }
  public boolean isEmpty(){
    return count == 0;
  }
  public boolean isFull(){
    return count == size;
  }
  @Override
  public String toString(){
    return Arrays.toString(this.arr);
  }
}


