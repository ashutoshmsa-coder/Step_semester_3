package week_7.class_problems;

public abstract class Toy {

    private static int counter = 1000;

    private final String toyId;
    private final String name;

    public Toy(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Toy name cannot be blank");
        }

        this.name = name;
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public String getToyId() {
        return toyId;
    }

    protected String getName() {
        return name;
    }

    public abstract String makeSound();
}