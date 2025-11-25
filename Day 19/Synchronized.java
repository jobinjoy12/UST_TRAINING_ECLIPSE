
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter{
    private int count = 0;

    ReentrantLock lock = new ReentrantLock();

    public void incrementUnsynchronized(){//increment method
        count++;
    }

    public synchronized void incrementSynchronized()
    {
        count++;
    }

    public int getCount()//get the count method , getter method
    {
        return count;
    }

}

class CounterTask implements Runnable //implements runnable interface
{
    public SharedCounter counter;
    public CounterTask(SharedCounter counter)
    {
        this.counter = counter;
    }
    @Override// override
    public void run()
    {
        for(int i =0;i<10_000;i++)
        {
         counter.incrementSynchronized();//run
        }
    }}

public class Main //main class
{
    public static void main(String[] args) throws InterruptedException{
        SharedCounter obj = new SharedCounter();
        Thread t1 = new Thread(new CounterTask(obj));
        Thread t2 = new Thread(new CounterTask(obj));
        Thread t3 = new Thread(new CounterTask(obj));
        Thread t4 = new Thread(new CounterTask(obj));
        Thread t5 = new Thread(new CounterTask(obj));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Final count: "+obj.getCount());
        System.out.println("Expected count: "+(5*10_000));
        //since the task is performed asynchronously , all the threads wont be able to access the counter method properly hence the increment wont happen as predicted and hence the count wont be equal to expected count .
    }
}
//The final count is inconsistent and is not 50,000 because the threads are asynchronous here and all the threads trying to access the counter at the same time so the final count won't reach 50,000.
// After using the synchronized keyword in the increment() method the final count is 50,000 as all the threads t1 to t5 are successfully able to access the method properly.