package com.wipro;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequent {
    public static void main(String[] args) {
        String paragraph = "This is a sample paragraph. This paragraph is just a sample. Sample is repeated.";

        // Normalize and split words
        List<String> words = Arrays.stream(paragraph.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                                   .collect(Collectors.toList());

        // Count occurrences
        Map<String, Long> wordCount = words.stream()
                                           .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Find the most frequent word
        String mostFrequent = wordCount.entrySet().stream()
                                       .max(Map.Entry.comparingByValue())
                                       .map(Map.Entry::getKey)
                                       .orElse(null);

        System.out.println("Most Frequent Word: " + mostFrequent);
    }
}
