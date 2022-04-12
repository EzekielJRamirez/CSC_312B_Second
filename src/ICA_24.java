import java.util.Vector;

/**
 * pages 162 - 164
 */

public class ICA_24 {
    public static void max_heap_insert(Vector<Integer> input, Integer key) {
        // your code here
    }

    public static void heap_increase_key(Vector<Integer> input, Integer i, Integer key) {
        // your code here
    }

    public static Integer heap_maximum(Vector<Integer> input) {
        // your code here
        return null;
    }

    public static Integer heap_extract_max(Vector<Integer> input) {
        // your code here
        return null;
    }

    public static void max_heapify(Vector<Integer> input, Integer i) {
        // your code here
    }

    public static Integer parent(Integer i) {
        // your code here
        return null;
    }

    public static Integer left(Integer i) {
        // your code here
        return null;
    }

    public static Integer right(Integer i) {
        // your code here
        return null;
    }

    public static void main(String[] args) {
        Vector<Integer> myHeap = new Vector<>();
        max_heap_insert(myHeap, 18);
        max_heap_insert(myHeap, 7);
        max_heap_insert(myHeap, 27);
        max_heap_insert(myHeap, 92);
        max_heap_insert(myHeap, 4);
        max_heap_insert(myHeap, 5);
        max_heap_insert(myHeap, 16);
        max_heap_insert(myHeap, 13);
        max_heap_insert(myHeap, 100);
        max_heap_insert(myHeap, 1);
        max_heap_insert(myHeap, 12);
        max_heap_insert(myHeap, 35);
        max_heap_insert(myHeap, 43);
        max_heap_insert(myHeap, 41);
        max_heap_insert(myHeap, 29);
        max_heap_insert(myHeap, 33);
        max_heap_insert(myHeap, 98);
        max_heap_insert(myHeap, 99);
        max_heap_insert(myHeap, 67);
        max_heap_insert(myHeap, 76);

        System.out.println(myHeap);

        heap_increase_key(myHeap, 2, 12);
        heap_increase_key(myHeap, 3, 25);
        heap_increase_key(myHeap, 1, 200);
        heap_increase_key(myHeap, 8, 15);
        heap_increase_key(myHeap, 0, 201);
        heap_increase_key(myHeap, 19, 77);

        System.out.println(myHeap);

        while(myHeap.size() > 0) {
            System.out.println(heap_extract_max(myHeap) + " ");
        }
        System.out.println();
    }
}
