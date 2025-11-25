package com.app.poly;

public abstract class Vehicle {
	protected String name;
	public Vehicle(String name) {
		this.name = name ;
	}
	public abstract void move();
	public String getName()
	{
		return name;
	}
}

class Car extends Vehicle
{
	public Car(String name) {
	super(name);}
	@Override 
	public void move() {
		System.out.println("The "+getName()+" is driving on the road.");
	}
}

class Bicycle extends Vehicle
{
	public Bicycle(String name) {
		super(name);}
	@Override 
	public void move() {
		System.out.println("The "+getName()+" is pedaling on the path.");
	}
}

class Airplane extends Vehicle
{
	public Airplane(String name) {
		super(name);}
	@Override 
	public void move() {
		System.out.println("The "+getName()+" is flying in the sky.");
	}
}

