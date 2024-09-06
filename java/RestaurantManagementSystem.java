import java.util.Scanner;

class Node {
    String foodName;
    int quantity;
    float price;
    int data;
    Node prev;
    Node next;
}

public class RestaurantManagementSystem {
    static Node headAdmin = null, tailAdmin = null;
    static Node headCustomer = null, tailCustomer = null;
    static Node headSales = null;
    static Scanner scanner = new Scanner(System.in);

    static void adminMenu() {
        System.out.println("\n\t\t\t\t\t\t\t1. View total sales");
        System.out.println("\t\t\t\t\t\t\t2. Add new items in the order menu");
        System.out.println("\t\t\t\t\t\t\t3. Delete items from the order menu");
        System.out.println("\t\t\t\t\t\t\t4. Display order menu");
        System.out.println("\t\t\t\t\t\t\t5. Back To Main Menu \n");
        System.out.print("\t\t\t\t\t\t\t Enter Your Choice --->");
    }

    static void customerMenu() {
        System.out.println("\n\t\t\t\t\t\t\t1. Place your order");
        System.out.println("\t\t\t\t\t\t\t2. View your ordered items");
        System.out.println("\t\t\t\t\t\t\t3. Delete an item from order");
        System.out.println("\t\t\t\t\t\t\t4. Display final bill");
        System.out.println("\t\t\t\t\t\t\t5. Back To Main Menu \n");
        System.out.print("\t\t\t\t\t\t\t Enter Your Choice --->");
    }

    static Node createAdmin(Node head, int data, String foodName, float price) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.price = price;
        newNode.quantity = 0;
        newNode.foodName = foodName;
        newNode.next = null;
        newNode.prev = null;

        if (head == null) {
            headAdmin = tailAdmin = newNode;
        } else {
            tailAdmin.next = newNode;
            newNode.prev = tailAdmin;
            tailAdmin = newNode;
        }
        return headAdmin;
    }

    static Node createCustomer(Node head, int data, int quantity) {
        Node newNode = new Node();
        Node temp1 = headAdmin;
        int flag = 0;

        while (temp1 != null) {
            if (temp1.data == data) {
                flag = 1;
                break;
            }
            temp1 = temp1.next;
        }

        if (flag == 1) {
            newNode.data = data;
            newNode.price = quantity * temp1.price;
            newNode.quantity = quantity;
            newNode.foodName = temp1.foodName;
            newNode.next = null;
            newNode.prev = null;

            if (head == null) {
                headCustomer = tailCustomer = newNode;
            } else {
                tailCustomer.next = newNode;
                newNode.prev = tailCustomer;
                tailCustomer = newNode;
            }
        } else {
            System.out.println("\n\t\t\t\t\t\t\tThis item is not present in the menu!");
        }
        return headCustomer;
    }

    // Implement other methods similarly

    public static void main(String[] args) {
        headAdmin = createAdmin(headAdmin, 1, "Samosa", 10);
        headAdmin = createAdmin(headAdmin, 2, "Chaat", 20);
        headAdmin = createAdmin(headAdmin, 3, "Manchurian", 15);
        headAdmin = createAdmin(headAdmin, 4, "Fried Rice", 180);
        headAdmin = createAdmin(headAdmin, 5, "Vada", 80);
        headAdmin = createAdmin(headAdmin, 6, "Butter Chicken", 280);
        headAdmin = createAdmin(headAdmin, 7, "Biryani", 140);
        headAdmin = createAdmin(headAdmin, 8, "Paneer Tikka", 180);
        headAdmin = createAdmin(headAdmin, 9, "Raita", 80);
        headAdmin = createAdmin(headAdmin, 10, "Aloo Gobi", 90);
        headAdmin = createAdmin(headAdmin, 11, "Gulab Jamun", 30);
        headAdmin = createAdmin(headAdmin, 12, "Rasgulla", 20);
        headAdmin = createAdmin(headAdmin, 13, "Laddu", 100);
        headAdmin = createAdmin(headAdmin, 14, "Rasmalai", 800);

        // Implement the main loop similarly
    }
}
