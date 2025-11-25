public class WorkerThread extends Thread {
    private String threadName;
    private int iterations;

    // constructor
    public WorkerThread(String name, int iterations) {
        this.threadName = name;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            System.out.println(threadName+" - "+(i+1));
        }
    }
    public static void demonstrateJoinMethod(Thread t1 , Thread t2) throws InterruptedException {

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
	public static void main(String[] args)
	{
        // two threads created here
        WorkerThread t1 = new WorkerThread("Thread-1", 5);
        WorkerThread t2 = new WorkerThread("Thread-2", 5);
		try {
            demonstrateJoinMethod(t1,t2);
        } catch (InterruptedException e) {e.printStackTrace();}
        

	}
   
}