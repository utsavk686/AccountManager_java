package com.wipro;

import java.util.*;

public class parallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        
        // Adding 1 million numbers to the list
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }

        // Using parallel stream with a more efficient summing approach without method reference
        int sum = numbers.parallelStream()
                          .mapToInt(Integer::intValue)  
                          .reduce(0, (a, b) -> a + b);  

        System.out.println("Sum of all values: " + sum);
    }
}
