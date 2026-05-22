package BPlusTree;
public class Main {
    public static void main(String[] args) {
        BPlusTree ds = new BPlusTree(3);
        ds.insert(10);
        ds.insert(20);
        System.out.println("BPlusTree insertions passed without error.");
    }
}
