package week_7.class_problems;

public class Week7Problem1 {

    public static void main(String[] args) {

        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");

        System.out.println(car.makeSound());
        System.out.println("Toy ID: " + car.getToyId());

        System.out.println(robot.makeSound());
        System.out.println("Toy ID: " + robot.getToyId());
    }
}