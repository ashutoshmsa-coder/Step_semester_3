package week_6.class_problems;

public class Week6Problem2 {

    public static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof StudentMember) {
            return "Single-level descendant";
        }

        return "Base library member";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("STU1", 3);

        StudentMember student =
                new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honors =
                new HonorsStudentMember("STU3", 3, "ECE", 2);

        FacultyMember faculty =
                new FacultyMember("STU4", 5, "Physics");


        System.out.println(general.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());


        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));


        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();


        LibraryMember[] members = {
            general,
            student,
            honors,
            faculty
        };


        System.out.println(
                getTotalBooksBorrowed(members)
        );
    }
}