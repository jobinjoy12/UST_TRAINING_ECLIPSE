class MyObject 
		{
			int value ;
			
		}

public class Main2 {
	public static void main (String[] args)
		{
		int number = 10;
		System.out.println(number);
		
		
		MyObject obj = new MyObject();
		obj.value = 20;
		System.out.println(obj.value);
		changePrimitive(number);
		System.out.println(number);
		changeObject(obj);
		System.out.println(obj.value);
		reassignObject(obj);
		System.out.println(obj.value);
		
		}
		public static void changePrimitive(int parameter){
			parameter = 50;
			System.out.println(parameter);
		}
		
		public static void changeObject(MyObject objParameter) {
			objParameter.value = 100;
			System.out.println(objParameter.value);
		}
		
		public static void reassignObject(MyObject objParameter ) {
			objParameter = new MyObject() ;
			objParameter.value = 200;
			System.out.println(objParameter.value);
		}
		
		
		

}
