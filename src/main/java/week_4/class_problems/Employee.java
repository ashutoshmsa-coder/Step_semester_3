package week_3.class_problems;

public class Employee {

    String id;
    double salary;

    // Constructor
    public Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    // Add bonus
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        // Give the same bonus to every employee
        for (Employee employee : employees) {
            employee.raiseSalary(5000);
        }

        // Print final salaries
        for (Employee employee : employees) {
            System.out.println(
                employee.id + " | Final Salary: Rs " + employee.salary
            );
        }
    }
}
