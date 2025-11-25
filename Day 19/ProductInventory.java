public class ProductInventory {
    private int stock = 100;
    
    public void addStock(int quantity)
    {
        stock += quantity;
    }

    public void removeStock(int quantity)
    {
        stock -= quantity;
    }

    public int getStock() {
        return stock;
    }
}

class Restocker extends Thread{
ProductInventory pi = new ProductInventory();
    @Override
    public void run()
    {
        for(int i =0;i<1000;i++)
            {
                pi.addStock(1);
            }
    }
    
}

class SalesAgent extends Thread{
    ProductInventory pi = new ProductInventory();
    @Override
    public void run()
    {
         for(int i =0;i<1000;i++)
            {
                pi.removeStock(1);
            }   
    }
}

public class Main{
 public static void main(String[] args) throws InterruptedException {
    Restocker re = new Restocker();
    Restocker re2 = new Restocker();
    SalesAgent sa2 = new SalesAgent();
    SalesAgent sa = new SalesAgent();
        ProductInventory pi = new ProductInventory();


    re.start();
    re2.start();
    sa.start();
    sa2.start();

    re.join();
    re2.join();
    sa.join();
    sa2.join();
    
System.out.println("Final Stock Count: "+pi.getStock());
    
// No, the final stock count may not be what you expected (i.e., initial stock + total added - total removed) due to a concurrency issue known as a race condition.
// A race condition occurs when multiple threads access and modify shared data simultaneously without proper synchronization. In the context of stock management, if multiple threads are adding or removing items from the stock at the same time, and the operations are not atomic or synchronized, they can interfere with each other. This leads to inconsistent or incorrect results.
        
        
}
}