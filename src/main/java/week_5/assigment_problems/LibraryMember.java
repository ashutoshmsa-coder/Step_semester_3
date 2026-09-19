package week_5.assigment_problems;

public class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = Integer.toHexString(answer.hashCode());
    }

    public static void main(String[] args) {

        LibraryMember m = new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println("Membership ID: "
                + m.getMembershipId());

        m.setMembershipId("FAKE-0000");

        System.out.println("After second ID update: "
                + m.getMembershipId());

        System.out.println("Name: "
                + m.getName());

        System.out.println("Premium Member: "
                + m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");

        System.out.println("Security answer stored successfully");
    }
}