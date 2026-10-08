package week_7.class_problems;

public class Week7Problem4 {

    public static void main(String[] args) {

        Blender blender = new Blender();

        blender.setSpeedLevel(3);

        System.out.println("Speed level: " + blender.getSpeedLevel());

        try {
            blender.setSpeedLevel(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid speed level rejected");
        }

        System.out.println("Speed level after rejection: "
                + blender.getSpeedLevel());

        System.out.println(blender.prepare());
        System.out.println(blender.clean());
    }
}