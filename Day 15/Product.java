
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Product {
    private int id = 0;
    private String name ;
    private double price ;

    public Product(int id , String name , double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "ID: "+id+" Name: "+name+" Price: "+price;
    }

    public static void main(String[] args) {
        Map< Integer , Product> productCatalog = new HashMap<>();
        Product p1 = new Product(1 , "Pen" ,300.0);
        Product p2 = new Product(2 , "Penicl" , 400.0);
        Product p3 = new Product(4 , "Ruler" , 30.0);
        productCatalog.put(p1.id, p1);
        productCatalog.put(p2.id,p2);
        productCatalog.put(p3.id,p3);
        System.out.println(productCatalog.get(1).toString());
        System.out.println(productCatalog.containsKey(1));
        System.out.println(productCatalog.containsKey(5));
        System.out.println("Before removing"+productCatalog.keySet());
        productCatalog.remove(1);
        for(Map.Entry<Integer , Product> e:productCatalog.entrySet())
        {
            System.out.println("Key: "+e.getKey()+": Value: "+e.getValue());
        }

        Map<Integer ,Integer> inventoryLevels = new TreeMap<>();
        inventoryLevels.put(1,1);
        inventoryLevels.put(2,1);
        inventoryLevels.put(3,1);
        inventoryLevels.put(1,3);
        System.out.println(inventoryLevels.get(1).toString());
        for(Map.Entry<Integer,Integer> e:inventoryLevels.entrySet())
        {
            System.out.println("Key: "+e.getKey()+": Value"+e.getValue());
        }
        System.out.println("Product id First: "+inventoryLevels.get(1).toString());
        System.out.println("Product id last: "+inventoryLevels.get(3).toString());
    }
}


