
public interface Shape {
	double getArea();
	double getPerimeter();
}

class Circle implements Shape
{
	private double radius = 0;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea(){
		return Math.PI*radius*radius;
	}
	
	public double getPerimeter(){
		return 2*Math.PI*radius;
	}
}

class Rectangle implements Shape
{
	private double height;
	private double width;
	
	public Rectangle(double height , double width) {
		this.height = height;
		this.width = width;
	}
	
	public double getArea()
	{
		return width*height;
	}
	
	public double getPerimeter()
	{
		return 2*(width+height);
	}
}

public class Main{
	public static void main(String[] main) {
		Shape circle = new Circle(5.0);
		Shape rectangle = new Rectangle(6.0,4.0);
		System.out.println(circle.getArea());
		System.out.println(circle.getPerimeter());
		System.out.println(rectangle.getArea());
		System.out.println(rectangle.getPerimeter());
	}
}
