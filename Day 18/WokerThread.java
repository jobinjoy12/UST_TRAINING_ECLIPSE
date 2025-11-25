class WorkerThread extends Thread {
    private String name ;

    public WorkerThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run()
    {
        System.out.println(getName()+" has started.");
        for (int i = 0; i < 3; i++) {
            System.out.println(getName()+" is performing "+ i +" of 3");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {System.out.println("Exception");
            }
            if(i ==2 )
            {
                Thread.yield();
                System.out.println("yiled() was called.");
            }
        }System.out.println(getName()+" has finished.");
    }
    
    
}

public class Main(){
    public static void main(String[] args) throws InterruptedException{
        WorkerThread threadA= new WorkerThread("Processor A");
        WorkerThread threadB = new WorkerThread("Processor B");
        WorkerThread threadC = new WorkerThread("Processor C");
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        System.out.println("Main thread waiting for Proccesor A");
        threadB.join();
        System.out.println("Main thread waiting for Processor B");
        Thread.sleep(2000);
        System.out.println("Delay of 2sec");
        System.out.println("All critical processors (A and B) have finished, and the main thread is continuing.");
    
    }
}
