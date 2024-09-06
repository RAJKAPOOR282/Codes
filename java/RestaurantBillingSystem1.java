import java.util.Scanner;

public class RestaurantBillingSystem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store the items ordered
        ArrayList<Item> items = new ArrayList<>();

        // Prompt the user to enter the items ordered
        System.out.println("Enter the items ordered:");
        while (true) {
            String itemName = scanner.nextLine();
            if (itemName.equals("")) {
                break;
            }

            // Get the quantity and price of the item
            System.out.println("Enter the quantity of " + itemName + ": ");
            int quantity = scanner.nextInt();

            System.out.println("Enter the price of " + itemName + ": ");
            double price = scanner.nextDouble();

            // Create a new Item object and add it to the list
            Item item = new Item(itemName, quantity, price);
            items.add(item);
        }

        // Calculate the total bill amount
        double totalBillAmount = 0.0;
        for (Item item : items) {
            totalBillAmount += item.getQuantity() * item.getPrice();
        }

        // Display the total bill amount
        System.out.println("Total bill amount: $" + totalBillAmount);
    }
}

class Item {

    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}