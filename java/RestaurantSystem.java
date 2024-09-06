import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + ": $" + price;
    }
}

class Order {
    ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.price;
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

public class RestaurantSystem {
    static ArrayList<MenuItem> menu = new ArrayList<>();
    static Order currentOrder = new Order();

    public static void main(String[] args) {
        initializeMenu();
        displayMenu();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter the item number to add to your order (0 to finish):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                currentOrder.addItem(menu.get(choice - 1));
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        currentOrder.displayOrder();
        System.out.println("Thank you for dining with us!");
    }

    static void initializeMenu() {
        menu.add(new MenuItem("Burger", 8.99));
        menu.add(new MenuItem("Pizza", 10.99));
        menu.add(new MenuItem("Salad", 5.99));
        // Add more items as needed
    }

    static void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}