package com.java.wildcard;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
	public double sumOfList(List<? extends Number> numbers)
	{
		double sum = 0;
		for(Number val : numbers) {
			sum += val.doubleValue();
			
		}
			return sum;
	}
		

	public void addIntegersToList(List<? super Integer> destination , List<Integer> source)
	{
		for(Integer num: source)
		{
			destination.add(num);
		}
	}
	
	public void printList(List<?> list)
	{
		for(Object item : list)
		{
			System.out.print(item+" ");
		}System.out.println();
	}
	
	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<Integer>(List.of(1,5,6,7,8));
		List<Double> list2 = new ArrayList<>(List.of(4.0,66.0,89.0,1.0,2.0));
		List<Integer> list3 = new ArrayList<>();
		List<Object> list4 = new ArrayList<>();
		List<Number> list5 = new ArrayList<>();
		ListProcessor lp1 = new ListProcessor();
		System.out.println(lp1.sumOfList(list1));
		System.out.println(lp1.sumOfList(list2));
		lp1.addIntegersToList(list3,list1);
		lp1.addIntegersToList(list4,list1);
		lp1.addIntegersToList(list5,list1);
		lp1.printList(list1);
		lp1.printList(list2);
		lp1.printList(list3);
		lp1.printList(list4);
		lp1.printList(list5);

		
	}
}
