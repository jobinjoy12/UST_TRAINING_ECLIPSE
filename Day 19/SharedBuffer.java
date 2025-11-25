
import java.util.ArrayList;
import java.util.List;

class SharedBuffer {//new class SharedBuffer
    final static int CAPACITY = 5;//constant
    List<Integer> buffer = new ArrayList<>();

    public synchronized void put(int item) throws InterruptedException//synchronized method
    {
        System.out.println("Producer: Putting X. Buffer size: Y");
        while(buffer.size()==CAPACITY){//if buffer is full
            System.out.println("Buffer is full. Waiting...");
            wait();
        }
         buffer.add(item);
         notifyAll();
    }

    public synchronized int get() throws InterruptedException
    {
        System.out.println("Consumer: Putting X. Buffer size: Y");
        while(buffer.isEmpty())
        {
            System.out.println("Buffer is empty. Waiting...");
            wait();
        }
        notifyAll();
        return buffer.remove(0);
    }
}

class Producer implements Runnable{
    SharedBuffer buff;
    public Producer(SharedBuffer buff)
    {
        this.buff = buff;
    }
    @Override
    public void run(){
        for (int i = 0; i <=20 ; i++) {
            int item = i;
            try {
                buff.put(item);
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            }
    }
}

class Consumer implements Runnable
{
    SharedBuffer buff;
    public Consumer(SharedBuffer buff)
    {
        this.buff = buff;
    }
    @Override
    public void run()
    {
        for (int i = 0; i <= 20; i++) {
        try {
            int item = buff.get();
            Thread.sleep(400);
        } catch (InterruptedException e) {}
    }
    }

}

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buff = new SharedBuffer();
        Producer prod = new Producer(buff);
        Consumer cons = new Consumer(buff);

        Thread t1 = new Thread(prod);
        Thread t2 = new Thread(cons);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        
    }
}
