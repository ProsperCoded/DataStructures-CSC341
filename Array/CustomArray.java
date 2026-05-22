package Array;

public class CustomArray {
    private int[] array1D;
    private int[][] array2D;
    private int[][][] multiArray;
    private int count;

    public CustomArray(int length) {
        array1D = new int[length];
        array2D = new int[length][length];
        multiArray = new int[length][length][length];
        count = 0;
    }

    public void insert(int item) {
        // resize when we're out of room
        if (count == array1D.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = array1D[i];
            array1D = newItems;
        }
        array1D[count++] = item;
    }

    public void removeAt(int index) {
        // basic guard so we don't crash
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // shift everything left to fill the gap
        for (int i = index; i < count; i++)
            array1D[i] = array1D[i + 1];
        count--;
    }

    public int indexOf(int item) {
        // simple linear search
        for (int i = 0; i < count; i++)
            if (array1D[i] == item)
                return i;
        return -1;
    }

    public void print() {
        // just dump what we have
        for (int i = 0; i < count; i++)
            System.out.println(array1D[i]);
    }
}
