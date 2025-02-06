package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sumElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> ls = new ArrayList<>();
		for(int i=0;i<num;i++) {
			ls.add(sc.nextInt());
		}
		
		int sum = ls.stream().reduce(0, (a,b)->a+b);
		System.out.println("the sum is: "+ sum);
	}

}
