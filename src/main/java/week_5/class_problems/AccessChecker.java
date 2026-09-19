package week_5.class_problems;

class MovieTicket {

    private String seatNumber;
    String screenId;              // default
    protected double ticketPrice;
    public String movieTitle;
}

public class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        // Same class: all access modifiers are allowed
        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        // Same package: default, protected and public are allowed
        if (accessorContext.equals("SAME_PACKAGE")) {

            if (fieldModifier.equals("private")) {
                return "DENIED";
            }

            return "ALLOWED";
        }

        // Different package: only public is allowed
        if (accessorContext.equals("DIFFERENT_PACKAGE")) {

            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        // Subclass in different package using its own type
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (fieldModifier.equals("protected")
                    || fieldModifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        // Subclass in different package using parent type
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {

            String result =
                classifyAccess(attempt[0], attempt[1]);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "private",
                "SAME_CLASS"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "DIFFERENT_PACKAGE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            summarizeBatch(attempts)
        );
    }
}
