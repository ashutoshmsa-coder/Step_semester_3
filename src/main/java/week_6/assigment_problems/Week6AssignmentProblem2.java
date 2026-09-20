package week_6.assigment_problems;

public class Week6AssignmentProblem2 {

    public static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof PremiumMember) {
            return "Second generation descendant";
        }

        return "Base gym member";
    }

    public static int getTotalSessionsAttended(
            GymMember[] members) {

        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {

        GymMember standard =
                new GymMember("MEM1", 1000);

        PremiumMember premium =
                new PremiumMember(
                        "MEM2",
                        1500,
                        "Coach Riya");

        EliteMember elite =
                new EliteMember(
                        "MEM3",
                        2500,
                        "Coach Arjun",
                        "L12");

        GroupClassMember group =
                new GroupClassMember(
                        "MEM4",
                        1200,
                        "Zumba");

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());

        System.out.println(
                classifyGeneration(elite));

        System.out.println(
                classifyGeneration(group));

        standard.attendSession();
        standard.attendSession();
        standard.attendSession();

        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();
        elite.attendSession();
        elite.attendSession();

        GymMember[] members = {
            standard,
            premium,
            elite,
            group
        };

        System.out.println(
                "Total Sessions: "
                + getTotalSessionsAttended(members));
    }
}