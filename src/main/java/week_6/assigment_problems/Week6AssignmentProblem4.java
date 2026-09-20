package week_6.assigment_problems;

public class Week6AssignmentProblem4 {

    public static String batchPrint(GymMember[] members) {

        StringBuilder report = new StringBuilder();

        for (GymMember member : members) {

            // Polymorphic method call
            report.append(member.displayInfo());

            // Safe downcast only for PremiumMember
            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                report.append(
                        " [Trainer via downcast: ")
                      .append(premium.getTrainerName())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {

            new GymMember("MEM1", 1000),

            new PremiumMember(
                    "MEM2",
                    1500,
                    "Coach Riya")
        };

        System.out.println(
                batchPrint(members));
    }
}