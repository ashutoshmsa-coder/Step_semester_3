package week_6.class_problems;

public class Week6Problem1 {

    public static void main(String[] args) {

        // Test StudentMember
        StudentMember s = new StudentMember("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println("Books Borrowed: " + s.getBooksBorrowed());

        // Test invalid member ID
        try {

            LibraryMember invalid = new LibraryMember("LB1", 3);
            System.out.println(invalid);

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid member rejected");
        }

        // Test enrollBatch
        String[] memberIds = {
            "STU1",
            "LB1",
            "STU2",
            " ",
            "STU3"
        };

        System.out.println(
            LibraryMember.enrollBatch(memberIds, 3)
        );
    }
}