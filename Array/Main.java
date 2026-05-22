package Array;
public class Main {
    public static void main(String[] args) {
        CustomArray ds = new CustomArray(2);
        ds.insert(10);
        ds.insert(20);
        ds.insert(30); // Should resize
        ds.removeAt(0); // removes 10
        System.out.println("Array index of 30: " + ds.indexOf(30));
    }
}
