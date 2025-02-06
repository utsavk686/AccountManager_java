package com.wipro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class findDuplicate {
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=0;i<num;i++) {
			numbers.add(sc.nextInt());
		}
		
		
		Set<Integer> seen = new HashSet<>();
	        List<Integer> duplicates = numbers.stream()
	                                          .filter(n -> !seen.add(n)) // If already in set, it's a duplicate
	                                          .collect(Collectors.toList());

	        System.out.println("Duplicates: " + duplicates);
	    
	
	}

}
