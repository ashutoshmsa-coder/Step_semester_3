package week_7.class_problems;

public class Week7Problem5 {

    public static void main(String[] args) {

        ParcelNote parcel = new ParcelNote("TRK-1");
        LetterNote letter = new LetterNote("LTR-1");

        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("J. Smith"));

        DeliveryNote note = new ParcelNote("TRK-2");
        System.out.println(note.confirmDelivery());

        DeliveryNote[] notes = {parcel, letter};

        DeliveryNote.logAll(notes);
    }
}