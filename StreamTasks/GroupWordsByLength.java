package com.wipro;
import java.util.*;
import java.util.stream.Collectors;

public class GroupWordsByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "car", "banana", "dog", "elephant", "ant");

        // Group words by their length
        Map<Integer, List<String>> groupedWords = words.stream()
                                                       .collect(Collectors.groupingBy(word -> word.length()));

        // Print the result
        System.out.println(groupedWords);
    }
}
