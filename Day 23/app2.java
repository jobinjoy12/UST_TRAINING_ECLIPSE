import java.util.List;

interface Shape {
	double getArea();
	void draw();
}

class Circle implements Shape {
	private double radius;
	public Circle(double radius) { this.radius = radius; }
	@Override public double getArea() { return Math.PI * radius * radius; }
	@Override public void draw() { System.out.println("Drawing Circle with radius " + radius); }
}

class Rectangle implements Shape {
	private double width;
	private double height;
	public Rectangle(double width, double height) { this.width = width; this.height = height; }
	@Override public double getArea() { return width * height; }
	@Override public void draw() { System.out.println("Drawing Rectangle with width " + width + " and height " + height); }
}

class ShapeProcessor {
	// Implement a method to calculate total area of shapes in a list
	public double calculateTotalArea(List<? extends Shape> shapes) {
		// Your code here
        double totArea = 0.0;
        for(Shape obj : shapes)
        {
            totArea +=  obj.getArea();
        }
		return totArea;
	}

	// Implement a method to draw all shapes in a list
	public void drawAllShapes(List<? extends Shape> shapes) {
		// Your code here
        for(Shape obj : shapes)
        {
            obj.draw();
        }
	}
}