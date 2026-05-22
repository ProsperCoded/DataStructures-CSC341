package Deque;
public class Main {
    public static void main(String[] args) {
        CustomDeque ds = new CustomDeque();
        ds.addFirst(10);
        ds.addLast(20);
        System.out.println("Deque removed first: " + ds.removeFirst());
        System.out.println("Deque removed last: " + ds.removeLast());
        System.out.println("Deque is empty: " + ds.isEmpty());
    }
}
