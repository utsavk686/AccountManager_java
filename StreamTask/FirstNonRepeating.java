package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String input = "aabbcdeff";

        // Finding the first non-repeating character
        Character firstNonRepeating = input.chars()  
                                           .mapToObj(c -> (char) c)  
                                           .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))  
                                           .entrySet().stream()  
                                           .filter(entry -> entry.getValue() == 1)  
                                           .map(entry -> entry.getKey())  
                                           .findFirst()  
                                           .orElse(null);  

        System.out.println("First non-repeating character: " + firstNonRepeating);
    }
}
