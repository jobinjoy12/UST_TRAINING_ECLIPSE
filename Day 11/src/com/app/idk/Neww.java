package com.app.idk;
interface Shape{
	public int getArea();
}

class Rectangle implements Shape{
protected int width;
protected int height;

public Rectangle(int width, int height) {
this.width = width;
this.height = height;
}


public int getWidth() {
return width;
}

public void setWidth(int width) {
this.width = width;
}

public int getHeight() {
return height;
}

public void setHeight(int height) {
this.height = height;
}

@Override
public int getArea() {
return width * height;
}
}

class Square implements Shape {
	public int size;
public Square(int size) {
	this.size = size;
}


@Override
public int getArea() {
	return size*size;
}
}

public class Neww{
	public static void main(String[] args)
	{
		Rectangle rec = new Rectangle(5,5);
		Square sq = new Square(5);
		System.out.println(rec.getArea());
		System.out.println(sq.getArea());
	}
}