import java.util.HashMap;
import java.util.Map;

public class keyval extends HashMap<String , Integer> {

public static void printQuantity(Map<String,Integer> map, String itemName)
    {
        String key = itemName;
        Integer a = map.get(itemName);
        if(a == null)
        {
        System.out.println(key +"not found in the Inventory.");
         }else{System.out.println("Key: "+key+" Value: "+map.get(key));}
    }

    public static void main(String[] args) {

    
    
    Map<String,Integer> map = new HashMap<>();
    map.put("Apples",10);
    map.put("Bananas",5);
    map.put("Oranges",8);
    System.out.println(map.get("Apples").toString());
    printQuantity(map,"Grapes");
    System.out.println("Before Updating: "+map); //printing values before updating
    map.put("Apples",15);
    map.put("Bananas",3);
    System.out.println("After Updating: "+map);//printing values after updating
    
    System.out.println("Current Inventory: ");
    for (Map.Entry<String,Integer> e : map.entrySet()) {
        Object key = e.getKey();
        Object val = e.getValue();
        System.out.println(key+": "+val);
    }
}}
