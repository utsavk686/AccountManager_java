package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

class Employs {
    private String name;
    private double salary;
    private String department;
    private int age;

    public Employs(String name, double salary, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", department='" + department + "', age=" + age + "}";
    }
}


public class YoungEmpDept {
    public static void main(String[] args) {
        List<Employs> employees = Arrays.asList(
            new Employs("John", 45000, "IT", 25),
            new Employs("Jane", 55000, "HR", 30),
            new Employs("Mike", 60000, "IT", 28),
            new Employs("Sara", 49000, "Finance", 22),
            new Employs("Tom", 70000, "HR", 24),
            new Employs("Anna", 65000, "IT", 23)
        );

        Map<String, Employs> youngestEmployees = employees.stream()
            .collect(Collectors.groupingBy(
                employee -> employee.getDepartment(),
                Collectors.collectingAndThen(
                    Collectors.minBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())),
                    Optional::get
                )
            ));

        youngestEmployees.forEach((department, employee) ->
            System.out.println(department + ": " + employee));
    }
}

