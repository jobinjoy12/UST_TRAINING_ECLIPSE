public class SharedCounter {
    // field to hold the counter value
    private int count = 0;

    // synchronized method to safely increment count
    public synchronized void increment() {
        count++;
    }

    // method to return current count
    public int getCount() {
        return count;
    }

    // main method to run the test
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter(); // create counter object

        // task that increments counter 10000 times
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task); // first thread
        Thread thread2 = new Thread(task); // second thread

        thread1.start(); // start first thread
        thread2.start(); // start second thread

        thread1.join(); // wait for first thread
        thread2.join(); // wait for second thread

        // print final result after both threads finish
        System.out.println("Final count: " + counter.getCount());
    }
}