package List;

public class CustomList {
    private Object[] items;
    private int count;

    public CustomList(int initialCapacity) {
        items = new Object[initialCapacity];
        count = 0;
    }
    
    public CustomList() {
        this(10);
    }

    public void add(Object item) {
        // grow array if it's full
        if (count == items.length) {
            Object[] newItems = new Object[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        items[count++] = item;
    }

    public void remove(int index) {
        // basic bounds check
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // slide items left, kinda slow but ok for now
        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];
        count--;
    }

    public Object get(int index) {
        // keep it safe
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        return items[index];
    }
    
    public int size() {
        // just return how many we actually used
        return count;
    }
}
