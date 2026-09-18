package week_4.assigment_problems;

public class Item {

    String itemName;
    int stock;

    // Constructor
    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    // Restock method
    void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public static void main(String[] args) {

        Item[] items = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        // Restock every item by 20
        for (Item item : items) {
            item.restock(20);

            System.out.println(
                item.itemName + " | Final Stock: " + item.stock
            );
        }
    }
}
