package week_3.class_problems;

public class SrmStudent {

    static String collegeName;
    static String academicYear;

    String name;

    // Static block runs only once
    static {
        collegeName = "SRM";
        academicYear = "2026";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        // Create multiple students
        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printDetails();
        }
    }
}
