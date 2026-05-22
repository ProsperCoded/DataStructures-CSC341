package Queue;

import java.util.Stack;

// Meant to implment queue with stacks.
public class StackQueue {
  Stack<Integer> store = new Stack<Integer>();
  Stack<Integer> offloadStore = new Stack<Integer>();
  public void enqueue(int value){
    store.add(value);
  }
  public void dequeue(){
    if(offloadStore.isEmpty()){
      // offload all elements except the first elements to offloadStore
      if (store.isEmpty() ) {
        throw new IllegalArgumentException();
      }
      while (store.size() > 0){
        offloadStore.add(store.pop());
      }
    }
    // remove first element, by removing last element in stack
    offloadStore.pop();
  }
  public Stack<Integer> reverse(Stack<Integer> stack){
    var temp = new Stack<Integer>();
    while (stack.size()>0){
      temp.add(stack.pop());
    }
    return temp;
  }
  @Override
  public String toString(){
    var temp = this.reverse(offloadStore);
    var temp2 = this.reverse(store);
    // re offload into stack 
    while( temp2.size()>0){
      temp.add(temp2.pop());
    }
    return temp.toString();
  }

}

