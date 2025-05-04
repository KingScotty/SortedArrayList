import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> items;

    public SortedList() {
        items = new ArrayList<>();
    }
//Binary search helper method
    private int findInsertIndex(String value) {
    int low = 0;
    int high = items.size() - 1;

        while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = value.compareToIgnoreCase(items.get(mid));

        if (cmp == 0) {
            return mid; // exact match
        } else if (cmp < 0) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

        return low; // insertion point
}

public void add(String value) {
    int index = findInsertIndex(value);
    items.add(index, value);
}

public int search(String value) {
    int low = 0;
    int high = items.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = value.compareToIgnoreCase(items.get(mid));

        if (cmp == 0) {
            return mid; // found
        } else if (cmp < 0) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return -low - 1; // not found; Java-style negative insertion point
}

public ArrayList<String> getItems() {
    return items;
}

@Override
public String toString() {
    return String.join(", ", items);
}
}