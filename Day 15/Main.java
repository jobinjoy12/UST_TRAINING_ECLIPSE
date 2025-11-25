
import java.util.ArrayList ;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class Main{//main class
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();//new array list
        List<Integer> list2 = new ArrayList<>();//new integer array list
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        ListIterator <Integer> listIterator = list2.listIterator();
        while(listIterator.hasNext())
        {
            int ele = listIterator.next();
            if(ele == 30 ){
                listIterator.add(35);
            }else if(ele == 40){
                listIterator.set(45);
            }
        }
        listIterator = list2.listIterator();
         while(listIterator.hasNext())
        {
            System.out.println(listIterator.next());
        }
        
        list.add("Mango");
        list.add("Apple");//adding elements to arraylist
        list.add("Orange");
        list.add("Jackfruit");
        list.add("Tomato");

        Iterator<String> it = list.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        Iterator<String> it2 = list.iterator();//creating iterator
        while(it2.hasNext())
        {
            String a = it2.next();
                if(a.charAt(0) == 'A')
                {
                    it2.remove();
                }
            }
        
        Iterator<String> it3 = list.iterator();//creating iterator

        while(it3.hasNext())//while loop
        {
            System.out.println(it3.next());
        }
    }
    }
    
