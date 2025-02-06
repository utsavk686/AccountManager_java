package com.wipro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Desired element in the list");
		int num = sc.nextInt();
		sc.nextLine();
		
		List<String> names = new ArrayList<>();
		for(int i=0;i<num;i++) {
			names.add(sc.nextLine());
		}
		
		// Sorting in ascending order using streams
        List<String> ascendingOrder = names.stream()
                                           .sorted()
                                           .collect(Collectors.toList());
        System.out.println("Ascending Order: " + ascendingOrder);

        // Sorting in descending order using streams
        List<String> descendingOrder = names.stream()
                                            .sorted(Comparator.reverseOrder())
                                            .collect(Collectors.toList());
        System.out.println("Descending Order: " + descendingOrder);
	}
}
