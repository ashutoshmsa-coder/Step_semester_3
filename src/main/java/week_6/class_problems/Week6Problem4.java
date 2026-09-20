package week_6.class_problems;

public class Week6Problem4 {

    public static String batchPrint(LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            // Polymorphism:
            // Java automatically calls the correct displayInfo()
            report.append(member.displayInfo());

            // Safe downcast only when the object is actually a StudentMember
            if (member instanceof StudentMember) {

                StudentMember student = (StudentMember) member;

                report.append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}