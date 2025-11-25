package com.app.binding;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args)
    {
        ArrayList<Vehicle> list = new ArrayList<>();
        Vehicle v = new Vehicle();
        Car c = new Car();
        Motorcycle m = new Motorcycle();
        list.add(v);
        list.add(c);
        list.add(m);
        for(Vehicle d : list){
            d.startEngine();
        }
    }
}