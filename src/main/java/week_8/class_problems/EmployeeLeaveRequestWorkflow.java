package week_8.class_problems;

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean canTakeLeave(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean canTakeLeave(int days) {
        return days <= 10;
    }
}

class Contractor extends Employee {

    Contractor(String name) {
        super(name);
    }

    @Override
    boolean canTakeLeave(int days) {
        return days <= 5;
    }
}

class LeaveRequest {

    Employee employee;
    String startDate;
    String endDate;
    int days;
    String status;

    LeaveRequest(Employee employee, String startDate,
                 String endDate, int days) {

        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.status = "Pending";
    }

    void submit() {
        if (employee.canTakeLeave(days)) {
            System.out.println(
                "Leave request submitted for " +
                employee.name + " (" +
                startDate + "-" + endDate + ")."
            );

            System.out.println("Status: " + status);
        } else {
            System.out.println(
                employee.name +
                " is not eligible for " +
                days + " days of leave."
            );
        }
    }

    void approve() {

        if (status.equals("Pending")) {
            status = "Approved";

            System.out.println(
                employee.name +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") approved."
            );

            System.out.println("Status: " + status);
        } else {
            System.out.println(
                "Cannot approve a request with status: " +
                status
            );
        }
    }

    void reject() {

        if (status.equals("Pending")) {
            status = "Rejected";

            System.out.println(
                employee.name +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") rejected."
            );

            System.out.println("Status: " + status);
        } else {
            System.out.println(
                "Cannot reject a request with status: " +
                status
            );
        }
    }

    void changeStatus(String newStatus) {

        if (!status.equals("Pending")) {
            System.out.println(
                "Cannot change leave request status from " +
                status + " to " + newStatus + "."
            );
        } else {
            status = newStatus;
        }
    }
}

public class EmployeeLeaveRequestWorkflow {

    public static void main(String[] args) {

        Employee john =
            new FullTimeEmployee("John");

        Employee jane =
            new PartTimeEmployee("Jane");

        LeaveRequest johnLeave =
            new LeaveRequest(
                john,
                "Jan 1",
                "Jan 5",
                5
            );

        johnLeave.submit();
        johnLeave.approve();

        LeaveRequest janeLeave =
            new LeaveRequest(
                jane,
                "Feb 10",
                "Feb 11",
                2
            );

        janeLeave.submit();
        janeLeave.reject();

        // Attempt to change Approved to Pending
        johnLeave.changeStatus("Pending");
    }
}