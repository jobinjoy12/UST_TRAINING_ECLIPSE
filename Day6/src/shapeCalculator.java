
public class shapeCalculator {
	public static void main(String[] args) {
		System.out.println(calculateRectangleArea(10,20));
		System.out.println(calculateCircleCircumference(10));
		System.out.println(getShapeName(3));
		System.out.println(isEven(8));
	}
	public static int calculateRectangleArea(int length, int width){
		int area = length * width;
		return area;
	}

	public static double calculateCircleCircumference(double radius) {
		double circumference =  (2 * Math.PI * radius);
		return circumference;
		
	}
	
	public static String getShapeName(int numberOfSides) {
		if(numberOfSides == 3) 
		{
			return "Triangle";
		}else if(numberOfSides == 4) {
			return "Quadrilateral";
		}
		return "Unknown Shape";
	}
	public static boolean isEven(int number) {
		if(number%2 == 0) {
			return true;
		}return false;
	}
}
