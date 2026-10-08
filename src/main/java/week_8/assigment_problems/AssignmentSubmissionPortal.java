package week_8.assigment_problems;

import java.time.LocalDate;

interface AssignmentType {
    double calculateFinalMarks(double awardedMarks, long lateDays);
    String getName();
}

class CodingAssignment implements AssignmentType {

    @Override
    public double calculateFinalMarks(double awardedMarks, long lateDays) {
        double penalty = lateDays * 0.10;
        return awardedMarks * (1 - penalty);
    }

    @Override
    public String getName() {
        return "Coding";
    }
}

class WrittenAssignment implements AssignmentType {

    @Override
    public double calculateFinalMarks(double awardedMarks, long lateDays) {
        double penalty = lateDays * 0.20;
        return awardedMarks * (1 - penalty);
    }

    @Override
    public String getName() {
        return "Written";
    }
}

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Assignment {
    private String title;
    private double maxMarks;
    private LocalDate dueDate;
    private AssignmentType type;

    Assignment(
        String title,
        double maxMarks,
        LocalDate dueDate,
        AssignmentType type
    ) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
        this.type = type;
    }

    String getTitle() {
        return title;
    }

    double getMaxMarks() {
        return maxMarks;
    }

    LocalDate getDueDate() {
        return dueDate;
    }

    AssignmentType getType() {
        return type;
    }
}

class Submission {

    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private String status;

    Submission(
        Student student,
        Assignment assignment,
        LocalDate submissionDate
    ) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = "Submitted";
    }

    void submit() {

        if ("Graded".equals(status)) {
            System.out.println(
                "Cannot resubmit: '" +
                assignment.getTitle() +
                "' has already been graded."
            );
            return;
        }

        System.out.println(
            student.getName() +
            "'s submission for '" +
            assignment.getTitle() +
            "' received."
        );

        System.out.println(
            "Status: " + status
        );
    }

    void grade(double awardedMarks) {

        if (!"Submitted".equals(status)) {
            System.out.println(
                "Cannot grade before submission."
            );
            return;
        }

        long lateDays = 0;

        if (submissionDate.isAfter(assignment.getDueDate())) {
            lateDays =
                java.time.temporal.ChronoUnit.DAYS.between(
                    assignment.getDueDate(),
                    submissionDate
                );
        }

        double finalMarks =
            assignment.getType()
                .calculateFinalMarks(
                    awardedMarks,
                    lateDays
                );

        if (finalMarks < 0) {
            finalMarks = 0;
        }

        if (finalMarks > assignment.getMaxMarks()) {
            finalMarks = assignment.getMaxMarks();
        }

        status = "Graded";

        if (lateDays == 0) {
            System.out.printf(
                "%s graded: %.0f/%.0f.%n",
                student.getName(),
                finalMarks,
                assignment.getMaxMarks()
            );
        } else {
            double penaltyPercentage =
                lateDays *
                (assignment.getType() instanceof CodingAssignment
                    ? 10
                    : 20);

            System.out.printf(
                "%s graded: %.0f/%.0f after %.0f%% late penalty.%n",
                student.getName(),
                finalMarks,
                assignment.getMaxMarks(),
                penaltyPercentage
            );
        }

        System.out.println(
            "Status: " + status
        );
    }
}

public class AssignmentSubmissionPortal {

    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding =
            new Assignment(
                "Linked List Lab",
                50,
                LocalDate.of(2026, 3, 10),
                new CodingAssignment()
            );

        Assignment written =
            new Assignment(
                "Design Essay",
                50,
                LocalDate.of(2026, 3, 12),
                new WrittenAssignment()
            );

        Submission ashaSubmission =
            new Submission(
                asha,
                coding,
                LocalDate.of(2026, 3, 10)
            );

        Submission raviSubmission =
            new Submission(
                ravi,
                written,
                LocalDate.of(2026, 3, 14)
            );

        ashaSubmission.submit();

        System.out.println();

        raviSubmission.submit();

        System.out.println();

        ashaSubmission.grade(45);

        System.out.println();

        raviSubmission.grade(40);

        System.out.println();

        ashaSubmission.submit();
    }
}