package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

class Employeees {
    private String name;
    private double salary;
    private String department;

    public Employeees(String name, double salary, String department) {
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


public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employeees> employees = Arrays.asList(
            new Employeees("John", 45000, "IT"),
            new Employeees("Jane", 55000, "HR"),
            new Employeees("Mike", 60000, "IT"),
            new Employeees("Sara", 49000, "Finance"),
            new Employeees("Tom", 70000, "HR"),
            new Employeees("Anna", 65000, "IT")
        );

        Map<String, Double> averageSalaries = employees.stream()
            .collect(Collectors.groupingBy(
                employee -> employee.getDepartment(),
                Collectors.averagingDouble(employee -> employee.getSalary())
            ));

        averageSalaries.forEach((department, avgSalary) -> 
            System.out.println(department + ": " + avgSalary));
    }
}

