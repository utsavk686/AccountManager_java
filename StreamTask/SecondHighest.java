package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighest {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=0;i<num;i++) {
			numbers.add(sc.nextInt());
		}

        // Find the second-highest number
        List<Integer> distinctSortedNumbers = numbers.stream()
                                                     .distinct()  // Remove duplicates
                                                     .sorted(Comparator.reverseOrder())  // Sort in descending order
                                                     .collect(Collectors.toList());  // Collect to a list

        if (distinctSortedNumbers.size() > 1) {
            System.out.println("Second highest: " + distinctSortedNumbers.get(1));  // Get the second element
        } else {
            System.out.println("No second-highest value found.");
        }
    }
}
