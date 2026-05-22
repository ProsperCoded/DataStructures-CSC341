package BinarySearchTree;

public class BinarySearchTree {
  protected class Node {
    public Node leftChild;
    public Node rightChild;
    public int value;

    public Node(int v) {
      this.value = v;
    }
    // public
  }

  protected Node root;

  public void insert(int v) {
    // standard BST insert
    if (root == null) {
      root = new Node(v);
      return;
    }
    Node current = root;
    Node lastParent = null;
    while (current != null) {
      lastParent = current;
      if (v > current.value) {
        current = current.rightChild;

      } else {
        current = current.leftChild;
      }
      // * track the parent, so we can add data later
    }
    if (v > lastParent.value) {
      lastParent.rightChild = new Node(v);
    } else if (v <= lastParent.value) {
      lastParent.leftChild = new Node(v);
    }
  };

  public boolean find(int v) {
    // walk down until we match or hit null
    Node current = root;

    while (current != null) {
      if (v > current.value) {
        current = current.rightChild;
      } else if (v < current.value) {
        current = current.leftChild;
      } else {
        // It is equal to the value
        return true;
      }
    }
    return false;
  };
}
