package com.wipro;

import java.util.*;
import java.util.stream.Collectors;

class Empl {
    int id;
    String name;

    Empl(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class LisToMap {
    public static void main(String[] args) {
        List<Empl> employees = Arrays.asList(
                new Empl(101, "Raj"),
                new Empl(102, "Utsav"),
                new Empl(103, "Rahul")
        );

        // Convert List to Map using Lambda (without ::)
        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(emp -> emp.getId(), emp -> emp.getName()));

        System.out.println("Employee Map: " + employeeMap);
    }
}
