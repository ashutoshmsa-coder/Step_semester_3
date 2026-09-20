package week_6.class_problems;

public class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(String memberId, int borrowLimit,
                         String department) {

        super(memberId, borrowLimit);

        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {

        return "Faculty Member | Department: "
                + department
                + " | Books Borrowed: "
                + getBooksBorrowed();
    }
}