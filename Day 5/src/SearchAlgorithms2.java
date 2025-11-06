import java.util.ArrayList;
import java.util.Collections;

class Customer implements Comparable<Customer>{
	int customerId;
	String customerName;
	String customerEmail;
	
	Customer(int Id , String name , String email){
		this.customerId = Id;
		this.customerName = name;
		this.customerEmail = email;
	}
	
	@Override
	public int compareTo(Customer other) {
		return Integer.compare(this.customerId, other.customerId);
	}
	
	@Override
	public String toString() {
		return "Customer { Id = "+customerId+"Name = " + customerName+"Email = " +customerEmail+" } " ;
	}
}
public class SearchAlgorithms2 
{
	public static void main(String[] args) 
	{
		ArrayList<Customer> arry = new ArrayList<>();
		arry.add(new Customer(105, "Alice", "alice@example.com"));
        arry.add(new Customer(101, "Bob", "bob@example.com"));
        arry.add(new Customer(107, "Charlie", "charlie@example.com"));
        arry.add(new Customer(103, "Diana", "diana@example.com"));
        arry.add(new Customer(106, "Ethan", "ethan@example.com"));
        arry.add(new Customer(102, "Fiona", "fiona@example.com"));
        arry.add(new Customer(104, "George", "george@example.com"));

		
        Collections.sort(arry);
        System.out.println(LinearSearch(arry , 105));
        System.out.println(LinearSearch(arry , 200));
        System.out.println(BinarySearch(arry,105));
        System.out.println(BinarySearch(arry , 200));
        
	}
	public static Customer LinearSearch(ArrayList <Customer> arry , int targetCustomerId) {
		for(int i=0 ; i<arry.size();i++) {
			Customer cust = arry.get(i);
			if(cust.customerId==targetCustomerId) {
				return cust;
			}
		}
		return null;
	}
	
	public static Customer BinarySearch(ArrayList <Customer> arry , int targetCustomerId) 
	{
		int low = 0 ;
		int high = arry.size()-1;
		while(low <= high) 
		{
			int mid = (low +high)/2;
			Customer midCustomer = arry.get(mid);
			
			if(midCustomer.customerId==targetCustomerId) 
			{
				return midCustomer;
			}else if(midCustomer.customerId < targetCustomerId) 
			{
				low = mid + 1 ;
			
			}else 
			{ high = mid - 1;
			}
	
		}
		return null;
	}
}