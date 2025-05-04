public class SortedListTest {
    public static void main(String[] args) {
        SortedList list = new SortedList();

        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        list.add("Mango");
        list.add("Blueberry");

        System.out.println("Sorted list: " + list);

        // Test search
        String search1 = "Cherry";
        String search2 = "Grapes";

        int result1 = list.search(search1);
        int result2 = list.search(search2);

        System.out.println("Search for '" + search1 + "': Found at index " + result1);
        System.out.println("Search for '" + search2 + "': Not found. Would be at index " + (-result2 - 1));
    }
}