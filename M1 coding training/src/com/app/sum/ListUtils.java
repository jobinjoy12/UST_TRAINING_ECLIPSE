package com.app.sum;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {
	public static List<String> removeDuplicates(List<String> list){
		Set<String> set = new LinkedHashSet<>();
		for(String str : list)
		{
			set.add(str);
		}
		return new ArrayList<>(set);
	}
}
