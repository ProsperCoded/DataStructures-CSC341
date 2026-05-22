package Stack;

public class CustomStack {
  private int[] items;
  private int loc;
  private int buffer = 3;
  private int bufferMultiple = 1;
  public CustomStack(){
    items = new int[this.buffer];
    loc = -1;
  }
  public void push(int item){
    // check if at the end of stack capacity
    if(loc+1 == buffer*bufferMultiple){
      // extend the stack 
      bufferMultiple++;
      extend(this.buffer * bufferMultiple);
    }
    this.loc++;
    this.items[this.loc] = item;
  }
  public Integer pop(){
    if(!isEmpty()){
      this.loc--;
      return this.items[this.loc+1];
    }
    return null;
  }
  public int peek(){
    return this.items[this.loc];
  }
  private boolean isEmpty(){
    // ? checking for -1
    return loc<=0;
  }
  // * temporary, not the main feature of a stack
  public int[] get(){
    return this.items;
  }
  private void extend (int newSize){
    var copy = this.items;
      
      this.items = new int[newSize];
      // clone 
      for (int i = 0; i< copy.length; i++){
        this.items[i] = copy[i];
      }
  }
  
}
