class CardPayment extends Payment {

    public void payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Charged: " + total);
    }
}

public class Payment {

    public void pay(double amount) {
        System.out.println("Paid: " + amount);
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {
            100, 50, 200, 75, 120
        };

        for (int i = 0; i < payments.length; i++) {

            if (payments[i] instanceof CardPayment) {
                CardPayment card = (CardPayment) payments[i];
                card.payWithProcessingFee(amounts[i]);
            } else {
                payments[i].pay(amounts[i]);
            }
        }
    }
}
