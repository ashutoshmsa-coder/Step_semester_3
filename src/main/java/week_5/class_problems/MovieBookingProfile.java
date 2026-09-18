package week_5.class_problems;

public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
        this.confirmed = false;
    }

    // Name constructor using this()
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // JavaBean getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // JavaBean getter and setter for confirmed
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP property
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {

        MovieBookingProfile profile =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(
            "Name: " + profile.getName()
        );

        profile.setConfirmed(true);

        System.out.println(
            "Confirmed: " + profile.isConfirmed()
        );

        profile.setOtp("4471");

        System.out.println("OTP set successfully");
    }
}