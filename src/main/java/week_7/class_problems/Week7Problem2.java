package week_7.class_problems;

public class Week7Problem2 {

    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {

        PackageBox packageBox = new PackageBox("TRK-88");
        Invoice invoice = new Invoice("INV-42");

        Printable[] items = {packageBox, invoice};

        printAll(items);
    }
}