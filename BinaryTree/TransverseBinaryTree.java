package BinaryTree;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.TransferHandler.TransferSupport;

// * My solution
public class TransverseBinaryTree {
  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    public Node(int v) {
      this.value = v;
    }
  }

  private Node root;

  public void insert(int v) {
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

  public void transverseInOrder() {
    this.transverseInOrder(root);
  }

  public void transversePostOrder() {
    this.transversePostOrder(root);
  }

  public void transversePreOrder() {
    this.transversePreOrder(root);
  }

  private void transverseInOrder(Node root) {
    if (root == null)
      return;

    transverseInOrder(root.leftChild);
    System.out.println(root.value);
    transverseInOrder(root.rightChild);
  }

  private void transversePreOrder(Node root) {
    if (root == null)
      return;

    System.out.println(root.value);
    transverseInOrder(root.leftChild);
    transverseInOrder(root.rightChild);
  }

  private void transversePostOrder(Node root) {
    if (root == null)
      return;

    transverseInOrder(root.leftChild);
    transverseInOrder(root.rightChild);
    System.out.println(root.value);

  }

  private int max(int l, int r) {
    if (l > r)
      return l;
    return l;
  }

  private int min(int l, int r) {
    if (l > r)
      return r;
    return l;
  }

  public int height() {
    return height(root);
  }

  private boolean isLeaf(Node node) {
    return node.leftChild == null && node.rightChild == null;
  }

  private int height(Node root) {
    if (root == null)
      return -1;
    if (isLeaf(root))
      return 0;

    var l = height(root.leftChild);
    var r = height(root.rightChild);
    return 1 + max(l, r);
  }

  public int min() {
    return min(root);
  }

  // * Minimum value in the tree
  // ! This can be used with BinarySearchTree and Binary Tree
  private int min(Node root) {
    if (root == null)
      return Integer.MAX_VALUE;
    if (isLeaf(root))
      return root.value;
    var l = min(root.leftChild);
    var r = min(root.rightChild);

    return min(min(l, r), root.value);
  }

  // ! This should only be used with Binary Search Tree
  private int minSearchTree(Node root) {
    if (root == null)
      throw new IllegalStateException();

    var current = root;
    var parent = current;

    while (current != null) {
      parent = current;
      // ? go to the minimum element, which is always at the left
      current = current.leftChild;
    }

    return parent.value;
  }

  private int maxSearchTree(Node node) {
    if (root == null)
      throw new IllegalStateException();

    var current = root;
    var parent = current;

    while (current != null) {
      parent = current;
      current = current.rightChild;
    }
    return parent.value;
  }

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) {
      return 0;
    }
    var nodesLeft = size(node.leftChild);
    var nodesRight = size(node.rightChild);
    return nodesLeft + nodesRight + 1;
  }

  public int countLeaves() {
    return countLeaves(root);
  }

  private int countLeaves(Node node) {
    if (node == null) {
      return 0;
    }
    // check if it's a leave
    if (node.leftChild == null && node.rightChild == null) {
      return 1;
    }

    var leavesFromLeft = countLeaves(node.leftChild);
    var leavesFromRight = countLeaves(node.rightChild);
    return leavesFromLeft + leavesFromRight;
  }

  public ArrayList<Integer> getAncestors(int v) {
    ArrayList<Integer> store = new ArrayList<>();
    var found = getAncestors(v, root, store);
    if (!found)
      return null;
    return store;
  }

  private boolean getAncestors(int v, Node node, ArrayList<Integer> store) {
    if (node == null) {
      return false;
    }
    if (v == node.value) {
      return true;
    }
    store.add(node.value);
    if (v > node.value) {
      return getAncestors(v, node.rightChild, store);
    } else {
      return getAncestors(v, node.leftChild, store);
    }
  }

  // Check if tree equals another
  public boolean equal(TransverseBinaryTree tree) {
    if (tree == null)
      return false;
    return equals(root, tree.root);
  }

  // * Check if the tree is equal to another tree
  // ? solution by me(prosper coded)
  private boolean equals(Node tree1, Node tree2) {
    // * both has the same tail
    if (tree1 == null && tree2 == null)
      return true;

    if (tree1 == null || tree2 == null) {
      return false;
    }
    ;

    if (tree1.value != tree2.value) {
      return false;
    }
    ;

    // recursively check the left and right node
    var leftEqual = equals(tree1.leftChild, tree2.leftChild);
    var rightEqual = equals(tree1.rightChild, tree2.rightChild);

    return leftEqual && rightEqual;
  }

  // ? solution by tutorial
  private boolean equals2(Node first, Node second) {
    if (first == null && second == null)
      return true;

    if (first != null && second != null) {
      return first.value == second.value && equals2(first.leftChild, second.leftChild)
          && equals2(first.rightChild, second.rightChild);
    }

    // ? case where one is null and the other is not
    return false;
  }

  // * Check if the tree is a binary search tree
  public boolean isBinarySearchTree() {
    // NODE , INFINITY, INFINITY
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(Node node, int min, int max) {
    if (node == null)
      return true;
    if (node.value > max || node.value < min) {
      return false;
    }
    var leftIsValid = isBinarySearchTree(node.leftChild, min, node.value - 1);
    // optimized if the left is false, don't check right
    if (!leftIsValid)
      return false;
    var rightIsValid = isBinarySearchTree(node.rightChild, node.value + 1, max);

    return rightIsValid;
  }

  // * Nodes at K distance
  // ? My solution
  public ArrayList<Integer> valuesAtKDistance(int k) {
    return valuesAtKDistance(k, root);
  }

  private ArrayList<Integer> valuesAtKDistance(int k, Node node) {
    if (node == null) {
      return null;
    }
    if (k == 0) {
      var values = new ArrayList<Integer>();
      values.add(node.value);
      return values;
    }
    var valuesLeft = valuesAtKDistance(k - 1, node.leftChild);
    var valuesRight = valuesAtKDistance(k - 1, node.rightChild);
    if (valuesLeft != null && valuesRight != null) {
      ArrayList<Integer> result = new ArrayList<>(valuesLeft);
      result.addAll(valuesRight);
      return result;
    }
    // return valid if either left right isn't null
    else if (valuesLeft == null) {
      return valuesRight;
    } else if (valuesRight == null) {
      return valuesLeft;
    }
    // return null, if both are null
    return null;
  }

  // ? Tutor solution (mosh )
  public ArrayList<Integer> valuesAtKDistance2(int distance) {
    ArrayList<Integer> store = new ArrayList<>();
    valuesAtKDistance2(distance, root, store);
    return store;
  }

  private void valuesAtKDistance2(int distance, Node node, ArrayList<Integer> store) {
    if (node == null) {
      return;
    }
    if (distance == 0) {
      store.add(node.value);
    }

    valuesAtKDistance2(distance - 1, node.leftChild, store);
    valuesAtKDistance2(distance - 1, node.rightChild, store);
  }
}
