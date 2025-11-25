class SharedCounter{
    private int count = 0;

    public synchronized void increment(){//increment method
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
         counter.increment(); //run
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

    }
}
//The final count is inconsistent and is not 50,000 because the threads are asynchronous here and all the threads trying to access the counter at the same time so the final count won't reach 50,000.
// After using the synchronized keyword in the increment() method the final count is 50,000 as all the threads t1 to t5 are successfully able to access the method properly.