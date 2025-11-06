import java.util.HashMap;
import java.util.Scanner;

class Practise8 {
	int bookid;
	String bookname;
	String author; 
	int price;
	
	Practise8(int bookid , String bookname , String author , int price) {
		this.bookid = bookid;
		this.bookname = bookname ; 
		this.author = author;
		this.price = price ;
	}
	@Override
	public String toString(){
		return "book id" + bookid + "book name" + bookname;
		}
	}


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cont = "yes";
		int number =0 ;
		HashMap<Integer,Practise8> map = new HashMap<>() ;
		while(cont.equalsIgnoreCase("yes")) {
		System.out.println("enter the number 1 2 3 4 ");
		number = sc.nextInt();
		switch(number) {
		case 1 :
			System.out.println("enter id name , author , price");	
			int bookid = sc.nextInt();
			sc.nextLine();
			String bookn = sc.nextLine().trim();
			String booka = sc.nextLine().trim();
			int price = sc.nextInt();
			sc.nextLine();
			Practise8 obj = new Practise8(bookid, bookn, booka, price);
			map.put(bookid,obj);
			break;
		
		case 2 :
			System.out.println("Enter id");
			int a = sc.nextInt();
			sc.nextLine();
			if(map.containsKey(a)) {
				System.out.println(map.get(a));
			}else{System.out.println("id doesnt exitst");}
			break;
			
		case 3 :
			System.out.println("Enter id");
			int b = sc.nextInt();
			sc.nextLine();
			if(map.containsKey(b)) {
				map.remove(b);
			}else{System.out.println("Id doesnt exist");}
			break;
		
		case 4 :
			
		    for(Practise8 values : map.values()) {
		    	System.out.println(values);
		    }break;
		}
		
		
	    System.out.println("Cont yes or no");
		cont = sc.nextLine().trim();
		}sc.close();}}
	

