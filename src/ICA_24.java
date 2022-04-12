import java.util.Vector;

/**
 * pages 162 - 164
 * <p>
 * code works check the final loop in the main body,
 * that is causing an endless loop
 */

public class ICA_24 {
    public static void max_heap_insert(Vector<Integer> input, Integer key) {
        // code was intended for array rather than vector
        input.add(null);
        input.set(input.size() - 1, Integer.MIN_VALUE);
//        Integer negat = Integer.MIN_VALUE;
        heap_increase_key(input, input.size() - 1, key);
    }

    public static void heap_increase_key(Vector<Integer> input, Integer i, Integer key) {
        if (i < input.size() && key < input.elementAt(i)) {
            // throw error
            System.out.println("new key is smaller than current key");
            return;
        }
//        System.out.println(i + ":\t" + key);
        input.set(i, key);
        while (i > 1 && input.elementAt(parent(i)) < input.elementAt(i)) {
            // swap A[i] with A[parent(i)]
            // I may need a temp value
            Integer temp = input.elementAt(i);
            input.set(i, input.elementAt(parent(i)));
            input.set(parent(i), temp);
            i = parent(i);
        }
    }

    public static Integer heap_maximum(Vector<Integer> input) {
        // your code here
        return input.elementAt(1);
    }

    public static Integer heap_extract_max(Vector<Integer> input) {
        if (input.size() < 1) {
            System.out.println("heap underflow");
            return null;
        }

        Integer max = input.elementAt(0);
        input.set(0, input.elementAt(input.size() - 1));
        // remove the last element
        input.remove(input.size() - 1);
        max_heapify(input, 0);
        return max;
    }

    public static void max_heapify(Vector<Integer> input, Integer i) {
        // your code here
//        if (input.size() < 2)
//            return;
        Integer l = left(i);
        Integer r = right(i);
        Integer largest;
        if (l <= input.size() && input.elementAt(l) > input.elementAt(i)) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= input.size() && input.elementAt(r) > input.elementAt(largest)) {
            largest = r;
        }
        if (largest != i) {
            // swap A[i] with A[largest]
            Integer temp = input.elementAt(i);
            input.set(i, input.elementAt(largest));
            input.set(largest, temp);
            max_heapify(input, largest);
        }
    }

    public static Integer parent(Integer i) {
        // the psuedo code asked for floor rounding
        return i / 2;
    }

    public static Integer left(Integer i) {
        return 2 * i;
    }

    public static Integer right(Integer i) {
        return (2 * i) + 1;
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

        while (myHeap.size() > 0) {
            System.out.print(heap_extract_max(myHeap) + " ");
        }
        System.out.println();
    }
}
