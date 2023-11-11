import java.util.*;

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSortingExample {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Alice", 60000));
        employees.add(new Employee("Bob", 45000));
      
        System.out.println("Unsorted Employees:");
        printEmployees(employees);

   
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("\nSorted Employees by Name (Ascending Order):");
        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
