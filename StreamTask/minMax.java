package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class minMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> ls = new ArrayList<>();
		for(int i=0;i<num;i++) {
			ls.add(sc.nextInt());
		}
		
		
		
		int max = ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		int min = ls.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
		
		System.out.println("Maximum is "+ max);
		System.out.println("Minimum is "+ min);
		
	}
	

}
