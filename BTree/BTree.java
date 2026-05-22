package BTree;

public class BTree {
    private int T;
    
    public class Node {
        int n;
        int[] key;
        Node[] child;
        boolean leaf = true;

        public Node(int t) {
            key = new int[2 * t - 1];
            child = new Node[2 * t];
            n = 0;
        }
    }

    private Node root;

    public BTree(int t) {
        T = t;
        root = new Node(t);
    }

    public void insert(int k) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node(T);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            splitChild(s, 0, r);
            insertNonFull(s, k);
        } else {
            insertNonFull(r, k);
        }
    }

    private void insertNonFull(Node x, int k) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && x.key[i] > k) {
                x.key[i + 1] = x.key[i];
                i--;
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            while (i >= 0 && x.key[i] > k) {
                i--;
            }
            i++;
            if (x.child[i].n == 2 * T - 1) {
                splitChild(x, i, x.child[i]);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertNonFull(x.child[i], k);
        }
    }

    private void splitChild(Node x, int i, Node y) {
        Node z = new Node(T);
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.key[j] = y.key[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j > i; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[i + 1] = z;
        for (int j = x.n - 1; j >= i; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[i] = y.key[T - 1];
        x.n = x.n + 1;
    }
}
