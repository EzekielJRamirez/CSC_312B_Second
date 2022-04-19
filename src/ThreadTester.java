import java.util.Vector;
import static java.lang.Math.max;

/**
 * This file is based on the hint
 * picture provided by Prof Sanders
 * pages 802 - 804 confirmed by Professor Sanders
 */

public class ThreadTester {
    static Integer content;
    // make a global linked list here for 'T'

    public static class Printer implements Runnable {
        String uid;

        public Printer(String idInput) {
            uid = idInput;
        }

        public void run() {
            while (content < 100) {
                content++;
                System.out.println(System.currentTimeMillis() +
                        "\t\tThread " + uid + content);
            }
        }
    }

    public static void main(String[] args) {
        content = 0;

        Thread t1 = new Thread(new Printer("A\t") );
        Thread t2 = new Thread(new Printer("B\t\t") );
        Thread t3 = new Thread(new Printer("C\t\t\t") );
        Thread t4 = new Thread(new Printer("D\t\t\t\t") );

        System.out.println("System Time (ms)\tThread #\tA\tB\tC\tD");
        System.out.println("=======================================" +
                "==================================");

        // spawn
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // sync
        try {
            t1.join();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            t2.join();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            t3.join();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            t4.join();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // spawn \  /
        //        \/
        // thread t1
        // thread t2
        // t1.start()
        // t2.start()
    }

    public static void pMergeSort(Integer p, Integer r, Integer s) {
        // p is the initial, r is the range of data
        // s is just 0
        // A and B are data structures
        Integer n = r - p + 1;
        if (n == 1) {
            // B[s] = A[p]
        } else {
            // let T[1...n] be a new array or linked list
            Integer q = (p + r) / 2;
            Integer q2 = q - p + 1;
            // spawn pMergeSort()
            pMergeSort(q + 1,r,q2 + 1);
            // sync
            pMerge(1, q2, q2 + 1, n, s);
        }
    }

    public static void pMerge(Integer p1, Integer r1, Integer p2,
                              Integer r2, Integer p3) {
        // your code here
        Integer n1 = r1 - p1 + 1;
        Integer n2 = r2 - p2 + 1;
        if (n1 < n2) {                  // ensure that n1 >= n2
            // exchange p1 with p2
            // exchange r1 with r2
            // exchange n1 with n2
        }
        if (n1 == 0) {                  // both empty?
            return;
        } else {
            // your code here
        }
    }

    public static Integer binarySearch(Integer x, Integer p, Integer r) {
        // your code here
        Integer low = p;
        Integer high = max(p, r + 1);
        while (low < high) {
            Integer mid = (low + high) / 2;
        }
        return high;
    }

    /**
     * helper method sync should help condense the sync command
     */
    public static void sync() {
        // your code here
    }
}
