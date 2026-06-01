package java8;

import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class EmployeeStreamData {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 90000),
                new Employee(2, "David", "IT", 85000),
                new Employee(3, "Sam", "HR", 70000),
                new Employee(4, "Tom", "HR", 75000),
                new Employee(5, "Mike", "Finance", 95000),
                new Employee(6, "Smith", "Finance", 88000)
        );

        // 1. Second Highest Salary

        Double secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0.0);

        System.out.println("Second Highest Salary : "
                + secondHighestSalary);


        // 2. Maximum Salary in Each Department

        Map<String, Double> maxSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(
                                                        Employee::getSalary)),
                                        emp -> emp.get().getSalary()
                                )
                        ));

        System.out.println("\nMaximum Salary In Each Department");

        maxSalaryByDept.forEach((dept, salary) ->
                System.out.println(dept + " -> " + salary));


        // 3. Employee with Highest Salary Per Department

        Map<String, Employee> highestEmployeeByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(
                                                        Employee::getSalary)),
                                        Optional::get
                                )
                        ));

        System.out.println("\nHighest Salary Employee Per Department");

        highestEmployeeByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> "
                        + emp.getName()
                        + " : "
                        + emp.getSalary()));
    }
}