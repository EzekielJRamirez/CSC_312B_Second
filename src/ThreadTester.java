import java.util.Vector;

import static java.lang.Math.max;

/**
 * This file is based on the hint
 * picture provided by Prof Sanders
 * pages 802 - 804 confirmed by Professor Sanders
 */

public class ThreadTester {
    static Integer content;
    static Vector<Integer> T;
    // make a global linked list here for 'T'

    public static class pMerger implements Runnable{
        // remake the pMergeSort here
        Vector B;
        Vector A;

        public void run() {}

        public static void pMergeSort(Vector<Integer> A, Integer p,
                                      Integer r,Vector<Integer> B, Integer s) {
            // p is the initial, r is the range of data
            // s is just 0
            // A and B are data structures
//        Thread t1 = new Thread();
//        Thread t2 = new Thread(new Printer("B\t\t"));
            Integer n = r - p + 1;
            if (n == 1 && B.size() != 0) {
                // B[s] = A[p]
                B.set(s, A.elementAt(p));
            } else {
                // let T[1...n] be a new array or linked list
//            Vector<Integer> T = new Vector<>(n);
                T = new Vector<>(n);
                Integer q = (p + r) / 2;    // end of first half
                Integer q2 = q - p + 1;     // start of second half
                // spawn
                pMergeSort(A, p, q, T, 1);
                pMergeSort(A,q + 1, r, T, q2 + 1);
//            t1.start();
//            t2.start();
                // sync
//            sync(t1);
//            sync(t2);
//            try {
//                t1.join();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }

//            try {
//                t2.join();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
                pMerge(T,1, q2, q2 + 1, n, B, s);
            }
            System.out.println(B);
        }

        public static void pMerge(Vector<Integer> T,Integer p1, Integer r1,
                                  Integer p2, Integer r2, Vector<Integer> A, Integer p3) {
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

        public static void sync(Thread t) {
            try {
                t.join();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

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

        Thread t1 = new Thread(new Printer("A\t"));
        Thread t2 = new Thread(new Printer("B\t\t"));
        Thread t3 = new Thread(new Printer("C\t\t\t"));
        Thread t4 = new Thread(new Printer("D\t\t\t\t"));

        System.out.println("System Time (ms)\tThread #\tA\tB\tC\tD");
        System.out.println("=======================================" +
                "==================================");

        // spawn
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // sync
        sync(t1);
        sync(t2);
        sync(t3);
        sync(t4);
//        try {
//            t1.join();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

//        try {
//            t2.join();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

//        try {
//            t3.join();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

//        try {
//            t4.join();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

        // spawn \  /
        //        \/
        // thread t1
        // thread t2
        // t1.start()
        // t2.start()

        Vector<Integer> A = new Vector<>();
        Vector<Integer> B = new Vector<>();
//        A.add(3);
//        B.add(0);
        for (int i = 1; i <= 7; i++) {
            A.add(i * 3);
            B.add(0);
        }
        System.out.println(A);
        System.out.println(B);
//        pMergeSort(A, 0,A.size() - 1,B,0);
    }

    public static void pMergeSort(Vector<Integer> A, Integer p,
                                  Integer r,Vector<Integer> B, Integer s) {
        // p is the initial, r is the range of data
        // s is just 0
        // A and B are data structures
//        Thread t1 = new Thread();
//        Thread t2 = new Thread(new Printer("B\t\t"));
        Integer n = r - p + 1;
        if (n == 1 && B.size() != 0) {
            // B[s] = A[p]
            B.set(s, A.elementAt(p));
        } else {
            // let T[1...n] be a new array or linked list
//            Vector<Integer> T = new Vector<>(n);
            T = new Vector<>(n);
            Integer q = (p + r) / 2;    // end of first half
            Integer q2 = q - p + 1;     // start of second half
            // spawn
            pMergeSort(A, p, q, T, 1);
            pMergeSort(A,q + 1, r, T, q2 + 1);
//            t1.start();
//            t2.start();
            // sync
//            sync(t1);
//            sync(t2);
//            try {
//                t1.join();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }

//            try {
//                t2.join();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
            pMerge(T,1, q2, q2 + 1, n, B, s);
        }
        System.out.println(B);
    }

    public static void pMerge(Vector<Integer> T,Integer p1, Integer r1,
                              Integer p2, Integer r2, Vector<Integer> A, Integer p3) {
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
    public static void sync(Thread t) {
        try {
            t.join();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
