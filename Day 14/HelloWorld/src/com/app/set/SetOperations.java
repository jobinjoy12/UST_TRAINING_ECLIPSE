package com.app.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
	public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
		Set<T> copy = new HashSet<>();
		copy.addAll(set1);
		copy.addAll(set2);
		return copy;
	}
	public static <T> Set<T> intersection(Set<T> set1 , Set<T> set2)
	{
		Set<T> newSet = new HashSet<>();
		newSet.addAll(set1);
		newSet.retainAll(set2);
		return newSet;
	}
	public static <T> Set<T> difference(Set<T> set1 , Set<T> set2)
	{
		Set<T> newSet = new HashSet<>();
		newSet.addAll(set1);
		newSet.removeAll(set2);
		return newSet;
	}
	public static <T> boolean isSubset(Set<T> potentialSubset, Set<T> potentialSuperset)
	{
		return potentialSuperset.containsAll(potentialSubset);
	}

	public static void main(String[] args) {
		Set<String> fruit1 = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange"));
		Set<String> fruit2 = new HashSet<>(Arrays.asList("Banana", "Grape", "Apple"));
		Set<String> fruit3 = new HashSet<>(Arrays.asList("Apple", "Banana"));

		 System.out.println(union(fruit1, fruit2));
		 System.out.println(intersection(fruit1, fruit2));
		 System.out.println(difference(fruit1, fruit2));
		 System.out.println(isSubset(fruit3, fruit1));//should be true.
		 System.out.println(isSubset(fruit1, fruit3));// returns false.

	}
}
