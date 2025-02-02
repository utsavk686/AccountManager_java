package task.java;

import java.util.Scanner;

public class Palindrome {
    public static boolean palindrome(String str){
        int n =str.length();
        for (int i=0;i<str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(palindrome(str));

    }
}
