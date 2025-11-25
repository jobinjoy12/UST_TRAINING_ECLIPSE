
import javax.swing.plaf.synth.SynthOptionPaneUI;

class newObject{
    public static Object monitor = new Object();
}
public class BlockedThread1 implements Runnable {
    @Override
    public void run(){
        synchronized (newObject.monitor) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {System.out.println("Exception");
            }
        }
    }
}

class BlockedThread2 implements Runnable{
    @Override
    public void run(){
        synchronized (newObject.monitor) {
            System.out.println("Blocked");
        }
    }
}

public class Main{
    public static void  main(String []args)
    {
        BlockedThread1 task1 = new BlockedThread1();
        Thread t1 = new Thread(task1);
        System.out.println(t1.getState());
        t1.start();
        Thread.sleep(100);
        System.out.println(t1.getState());
        BlockedThread2 task2 = new BlockedThread2();
        Thread t2 = new Thread(task2);
        t2.start();
        Thread.sleep(100);
        System.out.println(t2.getState());

        
    }
}
