package week_8.assigment_problems;

interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {

    @Override
    public int getDuration() {
        return 30;
    }

    @Override
    public double getCharge() {
        return 20;
    }

    @Override
    public String getName() {
        return "Quick";
    }
}

class NormalWash implements WashType {

    @Override
    public int getDuration() {
        return 45;
    }

    @Override
    public double getCharge() {
        return 30;
    }

    @Override
    public String getName() {
        return "Normal";
    }
}

class HeavyWash implements WashType {

    @Override
    public int getDuration() {
        return 60;
    }

    @Override
    public double getCharge() {
        return 45;
    }

    @Override
    public String getName() {
        return "Heavy";
    }
}

// Renamed from Student to LaundryStudent
// to avoid conflict with Student classes in other Week 8 files.
class LaundryStudent {

    private String name;

    public LaundryStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashingMachine {

    private String machineId;
    private boolean busy;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isAvailable() {
        return !busy;
    }

    public void startWash() {
        busy = true;
    }

    public void completeWash() {
        busy = false;
    }
}

class WashCycle {

    private LaundryStudent student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(
            LaundryStudent student,
            WashingMachine machine,
            WashType washType) {

        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public void start() {

        if (!machine.isAvailable()) {
            System.out.println(
                    "Machine " + machine.getMachineId()
                            + " is busy. "
                            + student.getName()
                            + " cannot start "
                            + washType.getName()
                            + " wash."
            );
            return;
        }

        machine.startWash();

        System.out.println(
                student.getName()
                        + " started "
                        + washType.getName()
                        + " wash on "
                        + machine.getMachineId()
        );

        System.out.println(
                "Duration: "
                        + washType.getDuration()
                        + " minutes"
        );

        System.out.println(
                "Charge: ₹"
                        + washType.getCharge()
        );

        System.out.println();
    }

    public void complete() {

        machine.completeWash();

        System.out.println(
                student.getName()
                        + "'s wash completed on "
                        + machine.getMachineId()
        );

        System.out.println();
    }
}

public class HostelLaundryQueue {

    public static void main(String[] args) {

        // Students
        LaundryStudent asha =
                new LaundryStudent("Asha");

        LaundryStudent ravi =
                new LaundryStudent("Ravi");

        LaundryStudent neha =
                new LaundryStudent("Neha");

        // Washing machines
        WashingMachine m1 =
                new WashingMachine("M1");

        WashingMachine m2 =
                new WashingMachine("M2");

        // Asha chooses Quick Wash on M1
        WashCycle ashaCycle =
                new WashCycle(
                        asha,
                        m1,
                        new QuickWash()
                );

        ashaCycle.start();

        // Ravi attempts Heavy Wash on busy M1
        WashCycle raviAttempt =
                new WashCycle(
                        ravi,
                        m1,
                        new HeavyWash()
                );

        raviAttempt.start();

        // Ravi uses M2 instead
        WashCycle raviCycle =
                new WashCycle(
                        ravi,
                        m2,
                        new HeavyWash()
                );

        raviCycle.start();

        // M1 completes
        ashaCycle.complete();

        // Neha uses M1 for Normal Wash
        WashCycle nehaCycle =
                new WashCycle(
                        neha,
                        m1,
                        new NormalWash()
                );

        nehaCycle.start();
    }
}