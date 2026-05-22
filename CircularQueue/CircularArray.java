package CircularQueue;

import java.util.Arrays;

public class CircularArray {
  int[] arr;
  int size;
  int f = 0;
  int r = 0;
  int count = 0;
  public CircularArray(int s){
    this.size = s;
    this.arr = new int[s];
  }
  public void enqueue(int value){
    if(isFull()){
      throw new IllegalArgumentException();
    }
    this.arr[r] = value;
    count++;
    r = (r+1) % size;
  }
  public int dequeue(){
    if(isEmpty()){
      throw new IllegalArgumentException();
    }
    var value = arr[f];
    arr[f] = 0;
    f = (f+1) % size;
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