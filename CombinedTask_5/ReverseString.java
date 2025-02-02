package task.java;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        
        StringBuilder sb = new StringBuilder(inputString);
        sb.reverse();

        
        System.out.println("Reversed String: " + sb.toString());
    }
}
