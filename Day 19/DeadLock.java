

public class DeadLock {//DeadLock class
    final Object resourceA = new Object();//creating object
    final Object resourceB = new Object();

    Thread thread1 = new Thread(()->{//new thread thread1
        System.out.println("thread1 is trying to acquire Resource A");
        synchronized(resourceA)//synchornized block
        {
            System.out.println("Thread 1: Locked Resource A");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}//try and catach block
            System.out.println("thread1 is trying to acquire resourceB");
            synchronized (resourceB) {//synchronized block
                System.out.println("Thread 1: Locked Resource B");
            }System.out.println("Thread 1: Released Resource B");
        }System.out.println("Thread 1: Released Resource A");
    });

    Thread thread2 = new Thread(()->{//new thread obj
        System.out.println("thread2 is trying to acquire Resource A");
        synchronized (resourceA)
         {
            System.out.println("Thread 2: Locked Resource A");
            try {
                Thread.sleep(100);//thread sleep
            } catch (InterruptedException e) {}  //try catch block 
            System.out.println("thread2 is trying to acquire Resource B");         
            synchronized (resourceB) {//synchronized block
                System.out.println("Thread 2: Locked Resource B");
            }System.out.println("Thread 2: Released Resource B");
            
        }System.out.println("Thread 2: Released Resource A");//println
    });

    public static void main(String[] args) {//main block
        DeadLock dead = new DeadLock();
        dead.thread1.start();// thread start
        dead.thread2.start();
    }
}
