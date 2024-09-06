import java.util.Scanner;

public class RestaurantBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu with item prices
        String[] menuItems = {"Pizza", "Chiken", "Paneer",};
        double[] itemPrices = {60.00, 75.25, 65.25};

        // Order details
        int[] orderQuantities = new int[menuItems.length];

        // Display menu
        System.out.println("~~~~~~~~ MENU ~~~~~~~~");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i] + " - Rs." + itemPrices[i]);
        }

        // Take order
        boolean continueOrdering = true;
        while (continueOrdering) {
            System.out.print("Enter the item number to order (0 to finish): ");
            int selectedItem = scanner.nextInt();

            if (selectedItem > 0 && selectedItem <= menuItems.length) {
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();
                orderQuantities[selectedItem - 1] += quantity;
            } else if (selectedItem == 0) {
                continueOrdering = false;
            } else {
                System.out.println("Invalid item number. Please try again.");
            }
        }

        // Calculate total and display receipt
        double total = 0;
        System.out.println("\nReceipt:");
        for (int i = 0; i < menuItems.length; i++) {
            if (orderQuantities[i] > 0) {
                double itemTotal = orderQuantities[i] * itemPrices[i];
                total += itemTotal;
                System.out.println(menuItems[i] + " x" + orderQuantities[i] + " - $" + itemTotal);
            }
        }
        System.out.println("\nTotal: $" + total);

        // Close the scanner
        scanner.close();
    }
}