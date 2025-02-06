package com.wipro;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Count occurrences of each character
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Print the result
        System.out.println("Character Count: " + charCount);

        scanner.close();
    }
}
