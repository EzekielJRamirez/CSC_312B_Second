import java.util.Vector;

/**
 * This file is based on the hint
 * picture provided by Prof Sanders
 */

public class ThreadTester {
    static Integer content;

    public static class Printer implements Runnable {
        String uid;

        public Printer(String idInput) {
            uid = idInput;
        }
        public void run() {
            while (content < 100) {
                content++;
                System.out.println(System.currentTimeMillis() +
                        "\t\tThread " + uid + " " + content);
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

        t1.start();
        t2.start();
        t3.start();
        t4.start();

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
    }
}
