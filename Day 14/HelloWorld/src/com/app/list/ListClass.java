package com.app.list;


import java.util.ArrayList;
import java.util.List;

public class ListClass {
    public static void main(String[] args) {
    List<String> shopping_list = new ArrayList<>();
    shopping_list.add("Milk");
    shopping_list.add("Bread");
    shopping_list.add("Eggs");
    shopping_list.add("Apples");
    System.out.println("Initial List:"+shopping_list);
    shopping_list.remove("Bread");
    shopping_list.add("Cheese");
    if(shopping_list.contains("Milk"))
    {
        System.out.println("Milk is on the list");
    }else{
        System.out.println("Milk is not on the list");
    }
    int a = shopping_list.indexOf("Eggs");
    System.out.println(a);
    System.out.println(shopping_list.set(a, "Organic Eggs"));
    System.out.println("Final Shopping List :"+shopping_list);
    System.out.println("List Size: "+shopping_list.size());
}
}