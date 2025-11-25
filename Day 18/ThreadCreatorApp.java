class MyThread extends Thread
{
   @Override
   public void run(){
    for(int i =0;i<5;i++){
    System.out.println(Thread.currentThread().getName()+" is alive!");
    try {
        Thread.sleep(500)   ;
    } catch (InterruptedException e) {
        System.out.println("InterruptedException");
    }
}}
    
}

class MyRunnable implements Runnable{
    public void run(){
        try {
        for (int i =0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" is executing!");
        
            Thread.sleep(500);
         }} catch (InterruptedException e) {System.out.println("InterruptedException Occured");}}
        }

public class ThreadCreatorApp{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        Thread t3 = new Thread(new MyRunnable());
        t3.start();

    }
}