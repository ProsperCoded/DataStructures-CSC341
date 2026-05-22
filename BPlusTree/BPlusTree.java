package BPlusTree;

public class BPlusTree {
    private int m;
    private Node root;

    private abstract class Node {
        int[] keys;
        int numKeys;
    }

    private class InternalNode extends Node {
        Node[] children;
        InternalNode(int m) {
            keys = new int[m];
            children = new Node[m + 1];
        }
    }

    private class LeafNode extends Node {
        LeafNode next;
        LeafNode(int m) {
            keys = new int[m];
        }
    }

    public BPlusTree(int m) {
        this.m = m;
        this.root = new LeafNode(m);
    }

    public void insert(int key) {
        // Simplified insert logic for placeholder
        if(root instanceof LeafNode) {
            LeafNode leaf = (LeafNode) root;
            if(leaf.numKeys < m - 1) {
                leaf.keys[leaf.numKeys++] = key;
            }
        }
    }
}
