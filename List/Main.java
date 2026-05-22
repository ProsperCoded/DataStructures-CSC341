package List;
public class Main {
    public static void main(String[] args) {
        CustomList ds = new CustomList(2);
        ds.add(10);
        ds.add(20);
        ds.add(30); // Resizes
        ds.remove(0); // Removes 10
        System.out.println("List element at 0: " + ds.get(0)); // Should be 20
        System.out.println("List size: " + ds.size());
    }
}
