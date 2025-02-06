package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // toString method for printing Employee details
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + '}';
    }
}



public class EmployeeSalary {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Pranav", 45000),
            new Employee("Rahul", 55000),
            new Employee("Sahul", 60000),
            new Employee("Raj", 49000),
            new Employee("Utsav", 70000)
        );

        // Find all employees earning more than 50,000 using streams
        List<Employee> highEarners = employees.stream()
            .filter(employee -> employee.getSalary() > 50000)  
            .collect(Collectors.toList()); 

        // Print the high earners
        highEarners.forEach(System.out::println);
    }
}

