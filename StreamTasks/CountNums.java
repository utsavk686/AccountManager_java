package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountNums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=0;i<num;i++) {
			numbers.add(sc.nextInt());
		}
		
		
		long count = numbers.stream()
                .filter(nums -> nums > 10) // Filter numbers greater than 10
                .count(); // Count the filtered elements

System.out.println("Count of numbers greater than 10: " + count);
	}

}
