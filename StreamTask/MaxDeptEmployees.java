package com.wipro;

import java.util.*;
import java.util.stream.Collectors;


class Employeee {
    private String name;
    private double salary;
    private String department;

    public Employeee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", department='" + department + "'}";
    }
}

public class MaxDeptEmployees {
    public static void main(String[] args) {
        List<Employeee> employees = Arrays.asList(
            new Employeee("John", 45000, "IT"),
            new Employeee("Jane", 55000, "HR"),
            new Employeee("Mike", 60000, "IT"),
            new Employeee("Sara", 49000, "Finance"),
            new Employeee("Tom", 70000, "HR"),
            new Employeee("Anna", 65000, "IT")
        );

        Map<String, Long> departmentCounts = employees.stream()
            .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.counting()));

        String departmentWithMaxEmployees = departmentCounts.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No department found");

        System.out.println("Department with the highest number of employees: " + departmentWithMaxEmployees);
    }
}

