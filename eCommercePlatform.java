package useCases;


import java.util.Scanner;

/*Polymorphism Scenario:
You are working on an application for an eCommerce platform. The platform has a feature to calculate discounts for various user types (e.g., Regular Customer, Premium Customer, and Employee). The discount calculation logic varies based on the user type.
Question:
How would you design a solution using polymorphism to calculate discounts for different user types?
Hint for Answer:
Use a base class Customer with a method calculateDiscount().
Create subclasses RegularCustomer, PremiumCustomer, and Employee that override the calculateDiscount() method.
Use polymorphism to call the appropriate implementation at runtime.*/


class Customer {
    public double calculateDiscount(double amount) {
        return 0.0; 
    }
}




class RegularCustomer extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.075; 
    }
}


class PremiumCustomer extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.15; 
    }
}


class Employee extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.25; 
    }
}


public class Task {
    public static void main(String[] args) {
    	System.out.println("Enter the purchase amount");
        Scanner sc = new Scanner(System.in);

        double purchaseAmount = sc.nextDouble();

        
        Customer regular = new RegularCustomer(); 
        Customer premium = new PremiumCustomer(); 
        Customer employee = new Employee(); 

    
        System.out.println("Discount for Regular Customer : " + regular.calculateDiscount(purchaseAmount)+ ", need to pay : "+(purchaseAmount-regular.calculateDiscount(purchaseAmount)));
        System.out.println("Discount for Premium Customer : " + premium.calculateDiscount(purchaseAmount)+ ", need to pay : "+(purchaseAmount-premium.calculateDiscount(purchaseAmount)));
        System.out.println("Discount for Employee : " + employee.calculateDiscount(purchaseAmount)+ ", need to pay : "+(purchaseAmount-employee.calculateDiscount(purchaseAmount)));
        sc.close();
    }
}
