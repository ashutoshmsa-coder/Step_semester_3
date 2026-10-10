import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    protected String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculatePay();

    abstract String getType();
}

class FullTime extends Employee {
    private double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }

    String getType() {
        return "FullTime";
    }
}

class PartTime extends Employee {
    private double hours;
    private double rate;

    PartTime(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        return hours * rate;
    }

    String getType() {
        return "PartTime";
    }
}

class Intern extends Employee {
    private double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }

    String getType() {
        return "Intern";
    }
}

public class PayrollRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            switch (parts[0]) {
                case "FullTime":
                    employees.add(
                        new FullTime(parts[1], Double.parseDouble(parts[2]))
                    );
                    break;

                case "PartTime":
                    employees.add(
                        new PartTime(
                            parts[1],
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])
                        )
                    );
                    break;

                case "Intern":
                    employees.add(
                        new Intern(parts[1], Double.parseDouble(parts[2]))
                    );
                    break;

                default:
                    System.out.println("Invalid employee type");
            }
        }

        double total = 0;
        Employee topEarner = null;

        for (Employee employee : employees) {
            double pay = employee.calculatePay();

            System.out.println(
                "Payslip[name=" + employee.name +
                ", type=" + employee.getType() +
                ", pay=" + pay + "]"
            );

            total += pay;

            if (topEarner == null ||
                pay > topEarner.calculatePay()) {
                topEarner = employee;
            }
        }

        System.out.println("Total " + total);

        if (topEarner != null) {
            System.out.println("top earner " + topEarner.name);
        }

        sc.close();
    }
}