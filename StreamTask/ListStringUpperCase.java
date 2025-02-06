package com.wipro;

import java.util.Arrays;
import java.util.List;

public class ListStringUpperCase {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("rk", "John", "alex");
		
		names.stream().map(x->x.toUpperCase()).forEach(x-> System.out.println(x));
	}

}
