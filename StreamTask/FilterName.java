package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterName {
	public static void main(String[] args) {
		
		System.out.println("Enter the no of names in the list: ");
		Scanner sc = new Scanner(System.in);
		int desiredLength = sc.nextInt();
		sc.nextLine();
		
		List<String> names = new ArrayList<>();
		
		for(int i=0;i<desiredLength;i++) {
			names.add(sc.nextLine());
		}
		
		List<String> result = names.stream().filter(name-> name.startsWith("A")).collect(Collectors.toList());
		
		
		System.out.println(result);
	}

}
