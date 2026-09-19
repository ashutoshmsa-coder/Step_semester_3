public class Employee {

    String employeeId;
    double salary;

    public Employee(String employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void raiseSalary(double bonus) {
        this.salary = this.salary + bonus;
    }

    public void printSalary() {
        System.out.println(employeeId + " | Final Salary: " + salary);
    }

    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        double bonus = 5000;

        for (int i = 0; i < employees.length; i++) {
            employees[i].raiseSalary(bonus);
            employees[i].printSalary();
        }
    }
}