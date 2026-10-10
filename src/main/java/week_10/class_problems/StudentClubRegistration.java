import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Student {
    private String rollNumber;
    private String name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return rollNumber.equals(other.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class StudentClubRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("ADD")) {
                Student student = new Student(parts[1], parts[2]);

                if (members.add(student)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }

            } else if (parts[0].equals("CONTAINS")) {
                Student student = new Student(parts[1], parts[2]);
                System.out.println("contains: " + members.contains(student));
            }
        }

        System.out.println("member count " + members.size());
        sc.close();
    }
}