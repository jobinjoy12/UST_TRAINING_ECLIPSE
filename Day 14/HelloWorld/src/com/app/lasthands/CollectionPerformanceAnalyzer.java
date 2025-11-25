package com.app.lasthands;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CollectionPerformanceAnalyzer {
	public static void main(String[] args) {
	 final int NUM_ELEMENTS = 100000;
	 final int NUM_OPERATIONS_FOR_SEARCH_DELETE = 10000;
	
	List<Integer> l1 = new ArrayList<>();
	
	long startTime = System.nanoTime();

	for(int i =0;i<=NUM_ELEMENTS-1;i++)
	{
		l1.add(i);
	 
	}long endTime = System.nanoTime();
	long durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

	System.out.println(" Operation adding elements in arraylist took: " + durationMillis + " ms");
	
	//LINKED LIST
	List<Integer> l2 = new LinkedList<>();
	startTime = System.nanoTime();

	for(int i =0;i<=NUM_ELEMENTS-1;i++)
	{
		l2.add(i);
	 
	}endTime = System.nanoTime();
	durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
	System.out.println(" Operation adding elements in linked list  took: " + durationMillis + " ms");
	
	//SEARCH
		
		int a1 = NUM_ELEMENTS/2;
		startTime = System.nanoTime();
		l1.contains(a1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Searching for a Element present took: " + durationMillis + " ms");
		int a2 = NUM_ELEMENTS+1;
		startTime = System.nanoTime();
		l1.contains(a2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Searching for Element not present took: " + durationMillis + " ms");
		
	
	//SEARCH
		
		startTime = System.nanoTime();
		l2.contains(a1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List Searching for a Element present took:" + durationMillis + " ms");
		startTime = System.nanoTime();
		l2.contains(a2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println("  Operation in Linked List Searching for a Element Not present took: " + durationMillis + " ms");
	
	//ACCESSING ARRAYLIST
		startTime = System.nanoTime();
		l1.get(0);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Accessing a Element at Beginning took:" + durationMillis + " ms");
		
		
	//ACCESSING ARRAYLIST
		startTime = System.nanoTime();
		l1.get(NUM_ELEMENTS/2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Accessing a Element at Middle took:" + durationMillis + " ms");
	
	//ACCESSING ARRAYLIST
		startTime = System.nanoTime();
		l1.get(NUM_ELEMENTS-1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Accessing a Element at End took:" + durationMillis + " ms");	
		
	//ACCESSING LINKEDLIST
		startTime = System.nanoTime();
		l2.get(0);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List Accessing a Element at Beginning took:" + durationMillis + " ms");
				
				
	//ACCESSING LINKEDLIST
		startTime = System.nanoTime();
		l2.get(NUM_ELEMENTS/2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List Accessing a Element at Middle took:" + durationMillis + " ms");
			
	//ACCESSING LINKEDLIST
		startTime = System.nanoTime();
		l2.get(NUM_ELEMENTS-1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List Accessing a Element at End took:" + durationMillis + " ms");	
	
	//REMOVING ARRAYLIST
		startTime = System.nanoTime();
		int a = l1.remove(0);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Removing a Element at Beginning took:" + durationMillis + " ms");
		l1.add(a);	
			
	//REMOVING ARRAYLIST
		startTime = System.nanoTime();
		a = l1.remove(NUM_ELEMENTS/2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Removing a Element at Middle took:" + durationMillis + " ms");
		l1.add(a);
	//REMOVING ARRAYLIST
		startTime = System.nanoTime();
		a = l1.remove(NUM_ELEMENTS-1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Array List Removing a Element at End took:" + durationMillis + " ms");	
		l1.add(a);
	//REMOVING LINKEDLIST
		startTime = System.nanoTime();
		l2.remove(0);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List removing a Element at Beginning took:" + durationMillis + " ms");
		l2.add(0);		
						
	//REMOVING LINKEDLIST
		startTime = System.nanoTime();
		l2.remove(NUM_ELEMENTS/2);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List removing a Element at Middle took:" + durationMillis + " ms");
		l2.add(NUM_ELEMENTS/2);		
	//REMOVING LINKEDLIST
		startTime = System.nanoTime();
		l2.remove(NUM_ELEMENTS-1);
		endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" Operation in Linked List removing a Element at End took:" + durationMillis + " ms");	
		l2.add(NUM_ELEMENTS-1);		
		
		
	//SET
		
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new LinkedHashSet<>();
		Set<Integer> set3 = new TreeSet<>();
		
	//ADD 1
		startTime = System.nanoTime();

		for(int i =0;i<=NUM_ELEMENTS-1;i++)
		{
			set.add(i);
		 
		}endTime = System.nanoTime();
		durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
		System.out.println(" HashSet Operation for adding elements took : " + durationMillis + " ms");
		
		//ADD 2
				startTime = System.nanoTime();

				for(int i =0;i<=NUM_ELEMENTS-1;i++)
				{
					set2.add(i);
				 
				}endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" LinkedHashSet Operation for adding elements took : " + durationMillis + " ms");	

				//ADD 3
				startTime = System.nanoTime();

				for(int i =0;i<=NUM_ELEMENTS-1;i++)
				{
					set3.add(i);
				 
				}endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" TreeSet Operation for adding elements took : " + durationMillis + " ms");
	

				//SEARCH SET 1
				
				a1 = NUM_ELEMENTS/2;
				startTime = System.nanoTime();
				set.contains(a1);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in HashSet Searching for a Element present took: " + durationMillis + " ms");
				a2 = NUM_ELEMENTS+1;
				startTime = System.nanoTime();
				set.contains(a2);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in HashSet Searching for Element not present took: " + durationMillis + " ms");
	
				//SEARCH SET 2
				
				a1 = NUM_ELEMENTS/2;
				startTime = System.nanoTime();
				set2.contains(a1);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in LinkedHashSet Searching for a Element present took: " + durationMillis + " ms");
				a2 = NUM_ELEMENTS+1;
				startTime = System.nanoTime();
				set2.contains(a2);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in LinkedHashSet Searching for Element not present took: " + durationMillis + " ms");	
	
				//SEARCH SET 3
				
				a1 = NUM_ELEMENTS/2;
				startTime = System.nanoTime();
				set3.contains(a1);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in TreeSet Searching for a Element present took: " + durationMillis + " ms");
				a2 = NUM_ELEMENTS+1;
				startTime = System.nanoTime();
				set3.contains(a2);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in TreeSet Searching for Element not present took: " + durationMillis + " ms");	
	
				//REMOVING HASHSET
				startTime = System.nanoTime();
				set.remove(0);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in HashSet removing a Element took:" + durationMillis + " ms");
				set.add(0);		
								
			//REMOVING LinkedHastSet
				startTime = System.nanoTime();
				set2.remove(NUM_ELEMENTS/2);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in LinkedHastSet removing a Element took:" + durationMillis + " ms");
				set2.add(NUM_ELEMENTS/2);		
			//REMOVING TreeSet
				startTime = System.nanoTime();
				set3.remove(NUM_ELEMENTS-1);
				endTime = System.nanoTime();
				durationMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
				System.out.println(" Operation in TreeSet removing a Element took:" + durationMillis + " ms");	
				set3.add(NUM_ELEMENTS-1);		
	
	
				//Adding elements at the end: Both are fast. ArrayList uses a dynamic array and usually adds in O(1), while LinkedList adds a new node at the tail in O(1).

				//Adding elements in the middle or start: ArrayList is slower because it has to shift elements (O(n)). LinkedList is also O(n) because it must traverse to the position, but once there, linking nodes is quick.

				//Accessing elements by index: ArrayList is very fast (O(1)) because it uses direct indexing. LinkedList is slow (O(n)) because it must traverse nodes sequentially.

				//Searching with contains(): Both are O(n) because they must scan through elements one by one.

				//Removing elements at the end: Both are fast (O(1)). ArrayList just drops the last element, LinkedList detaches the tail node.

				//Removing elements in the middle or start: ArrayList is slow (O(n)) because it shifts elements. LinkedList is O(n) because it must traverse to the node, but removal itself is quick once found.
	
	
	
	
	
	}
}