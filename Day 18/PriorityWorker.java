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
        for(int i =0;i<=1_000_000;i++)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {System.out.println("Exception");
            }
            counter++;
            if((i%100_000)==0){
                System.out.println(getTask()+" : current count = "+counter);
            }
        }System.out.println(getTask()+" finished. Total count: "+counter);
    }
    
}

public class Main{
    public static void main(String[] args) throws InterruptedException {
        PriorityWorker th1 = new PriorityWorker("HighPriorityWorker");
        PriorityWorker th2 = new PriorityWorker("NormalPriorityWorker");
        PriorityWorker th3 = new PriorityWorker("LowPriorityWorker");
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        Thread t3 = new Thread(th3);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}