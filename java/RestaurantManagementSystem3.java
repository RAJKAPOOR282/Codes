import java.util.Scanner;

public class RestaurantManagementSystem3 {
    private static final int MAX_ITEMS = 20;
    private static final int NAME_SIZE = 50;

    private static class FoodItem {
        String name;
        int quantity;
        float price;
    }

    private static final FoodItem[] menu = new FoodItem[MAX_ITEMS];
    private static int itemCount = 0;

    private static void initializeMenu() {
        addItem("Samosa", 1.5f);
        addItem("Chaat", 2.0f);
        addItem("Manchurian", 3.5f);
        // Add more items here if needed
    }

    private static void addItem(String name, float price) {
        if (itemCount < MAX_ITEMS) {
            menu[itemCount] = new FoodItem();
            menu[itemCount].name = name;
            menu[itemCount].price = price;
            menu[itemCount].quantity = 0;
            itemCount++;
        } else {
            System.out.println("Menu is full! Cannot add more items.");
        }
    }

    // Rest of the code remains the same

    private static void displayMainMenu() {
        System.out.println("\n************ Restaurant Management System ************");
        System.out.println("1. Admin Section");
        System.out.println("2. Customer Section");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void adminSection() {
        // Admin functionalities can be added here
        System.out.println("Admin Section is under construction.");
    }

    private static void displayCustomerMenu() {
        System.out.println("\n************ Customer Section ************");
        System.out.println("1. Place Order");
        System.out.println("2. View Ordered Items");
        System.out.println("3. Delete Item from Order");
        System.out.println("4. Display Final Bill");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void customerSection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayCustomerMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    viewOrderedItems();
                    break;
                case 3:
                    deleteItemFromOrder();
                    break;
                case 4:
                    displayFinalBill();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n************ Menu ************");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%d. %s - $%.2f\n", i + 1, menu[i].name, menu[i].price);
        }

        System.out.print("Enter item number to order: ");
        int itemNumber = scanner.nextInt();
        if (itemNumber < 1 || itemNumber > itemCount) {
            System.out.println("Invalid item number! Please enter a valid one.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        menu[itemNumber - 1].quantity += quantity;
        System.out.println("Item added to the order.");
    }

    private static void viewOrderedItems() {
        System.out.println("\n************ Ordered Items ************");
        for (FoodItem item : menu) {
            if (item != null && item.quantity > 0) {
                System.out.printf("%s - Quantity: %d\n", item.name, item.quantity);
            }
        }
    }

    private static void deleteItemFromOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n************ Delete Item from Order ************");
        for (int i = 0; i < itemCount; i++) {
            if (menu[i].quantity > 0) {
                System.out.printf("%d. %s\n", i + 1, menu[i].name);
            }
        }

        System.out.print("Enter item number to delete from order: ");
        int itemNumber = scanner.nextInt();
        if (itemNumber < 1 || itemNumber > itemCount || menu[itemNumber - 1].quantity == 0) {
            System.out.println("Invalid input or item number! Please enter a valid one.");
            return;
        }

        menu[itemNumber - 1].quantity = 0;
        System.out.println("Item deleted from the order.");
    }

    private static void displayFinalBill() {
        System.out.println("\n************ Final Bill ************");
        float totalBill = 0;
        for (FoodItem item : menu) {
            if (item != null && item.quantity > 0) {
                System.out.printf("%s - Quantity: %d - Total Price: $%.2f\n", item.name, item.quantity, item.quantity * item.price);
                totalBill += item.quantity * item.price;
            }
        }
        System.out.printf("Total Bill: $%.2f\n", totalBill);
    }

    public static void main(String[] args) {
        initializeMenu();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminSection();
                    break;
                case 2:
                    customerSection();
                    break;
                case 3:
                    System.out.println("Thank you for using the Restaurant Management System.");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}