package com.java.extndgener;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilites {
	public static <T extends Comparable<T>> T findMax(List<T> list) {
		if(list == null||list.isEmpty()) {
			throw new IllegalArgumentException("list cannot be null");
		}
		T max = list.get(0);
		for(int i =0;i<list.size();i++)
		{
			if(list.get(i).compareTo(max)>0)
			{
				max = list.get(i);
			}
		}
		return max;
	}
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		list = List.of(10, 5, 20, 15);
		List<String> list2 = new ArrayList<>();
		list2 = List.of("apple","zebra","banana");
		int a = findMax(list);
		String str = findMax(list2);
		System.out.println(a);
		System.out.println(str);
	}
}

