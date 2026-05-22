package BinarySearchTree;

// this is the solution suggested by DSA course instructor 
public class BinarySearchTree2 {
  private class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
      this.value = value;
    }
    @Override
    public String toString(){
      return "Node  ="+ value; 
    }
  }
  private Node root;

  public void insert(int value){
    if(root==null){
      root = new Node(value);
      return;
    }

    var node = new Node(value);
    var current = root;
    while(true){
      if(value < current.value){
        // * check for parent 
        if(current.leftChild == null){
          current.leftChild = node;
          break;
        }
        current = current.leftChild;
        
      }else {
        // * check for parent 
        if(current.rightChild ==null){
          current.rightChild = node;
          break;
        }
        current=current.rightChild;
      }
    }
  }
  
  public boolean find( int value){

    var current = root;
    while (current!=null){
      if(value < current.value){
        current = current.leftChild;
      }
      else if (value > current.value){
        current = current.rightChild;
      }
      else return true;
    }
    return false;
  }
}
