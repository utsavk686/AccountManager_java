package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindEven {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in the list");
		int num = sc.nextInt();
		
		List<Integer> ls = new ArrayList<>();
		for(int i=0;i<num;i++) {
			ls.add(sc.nextInt());
		}
		
		List<Integer> evenNo = ls.stream().filter(x->x%2==0).collect(Collectors.toList());
		
		System.out.println("Even no in the lists are: "+ evenNo);
	
		
	}

}
