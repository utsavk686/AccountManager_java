package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGroup {
    public static void main(String[] args) {
    	System.out.println("Enter the no of Words in the list: ");
		Scanner sc = new Scanner(System.in);
		int desiredLength = sc.nextInt();
		sc.nextLine();
		
		List<String> words = new ArrayList<>();
		
		for(int i=0;i<desiredLength;i++) {
			words.add(sc.nextLine());
		}
       
        
        // Group words by their sorted characters
        Map<String, List<String>> anagramGroups = words.stream()
                .collect(Collectors.groupingBy(word -> sortChars(word)));

        // Filter only the groups that have more than one word
        List<List<String>> result = anagramGroups.values().stream()
                .filter(group -> group.size() > 1)
                .collect(Collectors.toList());

        System.out.println("Anagram Groups: " + result);
    }

    private static String sortChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
