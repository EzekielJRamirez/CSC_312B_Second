/**
 *
 */

public class Final {
    // HINT: make all data structures global
    static int threadCounter;

    public static class myThread extends Thread {
        public void run() {
            System.out.println("MyThread running");
            threadCounter++;
            System.out.println(threadCounter);
        }
    }

    public static void main(String[] args) {
        threadCounter = 0;
        myThread myThread = new myThread();
        myThread myThread2 = new myThread();

        // spawn
        myThread.start();
        myThread2.start();

        // sync
        while( threadCounter < 2) {
            // NOP
        }

        System.out.println("After all threads are finished");
    }
}
