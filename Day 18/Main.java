class PriorityWorker implements Runnable{
    private String task;

    public PriorityWorker(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public void run(){
        long counter = 0;
        for(int i =0;i<=1_000_000;i++)//for loop
        {
            counter++;//counter increment
            if((i%100_000)==0){//if loop
                System.out.println(getTask()+" : current count = "+counter);
            }
        }System.out.println(getTask()+" finished. Total count: "+counter);
    }
    
}
//main class
public class Main{
    public static void main(String[] args) throws InterruptedException {
        PriorityWorker th1 = new PriorityWorker("HighPriorityWorker");
        PriorityWorker th2 = new PriorityWorker("NormalPriorityWorker");
        PriorityWorker th3 = new PriorityWorker("LowPriorityWorker");
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);//creating and wrapping thread
        Thread t3 = new Thread(th3);

        t1.setPriority(Thread.MAX_PRIORITY);//setting priortiy
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();//starting thread
        
        t2.start();
        
        t3.start();
        t1.join();//join 
        t2.join();
        t3.join();
    }
}// Solution for Learner Hands-on Task: Experiment with Thread Priorities

//- The HighPriorityWorker does not consistently finish faster than the others. Sometimes it prints progress messages earlier, but other times the normal or low priority threads interleave and finish first.
//- The finishing order is not guaranteed. Even though you set priorities (MAX_PRIORITY, NORM_PRIORITY, MIN_PRIORITY), the JVM and operating system scheduler decide how CPU time is allocated. On many systems, priorities are treated only as hints, not strict rules.
//- All three threads eventually complete their work. Each worker counts to 1,000,000 and prints progress, but the interleaving of messages varies from run to run.
