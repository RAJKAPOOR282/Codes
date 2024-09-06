import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cab {
    private String cabId;
    private boolean available;

    public Cab(String cabId) {
        this.cabId = cabId;
        this.available = true;
    }

    public String getCabId() {
        return cabId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Customer {
    private String customerId;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}

class CabBookingSystem {
    private List<Cab> availableCabs;
    private List<Cab> bookedCabs;

    public CabBookingSystem() {
        availableCabs = new ArrayList<>();
        bookedCabs = new ArrayList<>();
        initializeCabs(); // Initialize some cabs for testing
    }

    private void initializeCabs() {
        for (int i = 1; i <= 5; i++) {
            availableCabs.add(new Cab("Cab" + i));
        }
    }

    public void displayAvailableCabs() {
        System.out.println("Available Cabs:");
        for (Cab cab : availableCabs) {
            System.out.println(cab.getCabId());
        }
    }

    public void bookCab(Customer customer) {
        if (availableCabs.isEmpty()) {
            System.out.println("No cabs available at the moment. Please try again later.");
            return;
        }

        Cab selectedCab = availableCabs.remove(0);
        selectedCab.setAvailable(false);
        bookedCabs.add(selectedCab);

        System.out.println("Cab booked successfully. Cab ID: " + selectedCab.getCabId() +
                           ", Customer ID: " + customer.getCustomerId());
    }

    public void endTrip(Customer customer) {
        for (Cab cab : bookedCabs) {
            if (!cab.isAvailable() && bookedCabs.contains(cab)) {
                availableCabs.add(cab);
                bookedCabs.remove(cab);

                cab.setAvailable(true);

                System.out.println("Trip ended successfully. Cab ID: " + cab.getCabId() +
                                   ", Customer ID: " + customer.getCustomerId());
                return;
            }
        }
        System.out.println("No active trip found for customer " + customer.getCustomerId());
    }
}

public class Main {
    public static void main(String[] args) {
        CabBookingSystem cabBookingSystem = new CabBookingSystem();

        Customer customer1 = new Customer("Cust1");
        Customer customer2 = new Customer("Cust2");

        cabBookingSystem.displayAvailableCabs();

        cabBookingSystem.bookCab(customer1);
        cabBookingSystem.displayAvailableCabs();

        cabBookingSystem.bookCab(customer2);
        cabBookingSystem.displayAvailableCabs();

        cabBookingSystem.endTrip(customer1);
        cabBookingSystem.displayAvailableCabs();
    }
}
