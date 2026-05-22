package BTree;
public class Main {
    public static void main(String[] args) {
        BTree ds = new BTree(3);
        ds.insert(10);
        ds.insert(20);
        ds.insert(5);
        ds.insert(6);
        ds.insert(12);
        ds.insert(30);
        ds.insert(7);
        ds.insert(17); // triggers splits
        System.out.println("BTree insertions passed without error.");
    }
}
