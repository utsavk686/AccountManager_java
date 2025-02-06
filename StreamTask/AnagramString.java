package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        // Check if both strings are anagrams
        boolean isAnagram = isAnagram(str1, str2);

        System.out.println("Are the strings anagrams? " + isAnagram);

        scanner.close();
    }

    private static boolean isAnagram(String str1, String str2) {
       
        if (str1.length() != str2.length()) {
            return false;
        }

        
        return str1.chars().sorted()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList())
                .equals(str2.chars().sorted()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()));
    }
}
