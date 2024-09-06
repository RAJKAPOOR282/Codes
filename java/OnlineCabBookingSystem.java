import java.util.ArrayList;
import java.util.Scanner;

class Cab {
    String name;
    int availableSeats;
    String carVariety;

    Cab(String name, int availableSeats, String carVariety) {
        this.name = name;
        this.availableSeats = availableSeats;
        this.carVariety = carVariety;
    }

    boolean book(int seats) {
        if (availableSeats >= seats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }
}

public class OnlineCabBookingSystem {
    public static void main(String[] args) {
        ArrayList<Cab> cabs = new ArrayList<>();
        cabs.add(new Cab("ABC Cab", 4, "Sedan"));
        cabs.add(new Cab("XYZ Cab", 6, "SUV"));

        Scanner input = new Scanner(System.in);

        // Display the list of available cabs
        System.out.println("Available Cabs:");
        for (int i = 0; i < cabs.size(); i++) {
            Cab cab = cabs.get(i);
            System.out.println((i + 1) + ". " + cab.name + " (" + cab.carVariety + ") - Available Seats: " + cab.availableSeats);
        }

        // Prompt user to select a cab
        System.out.print("Select a cab: ");
        int choice = input.nextInt();
        if (choice < 1 || choice > cabs.size()) {
            System.out.println("Invalid choice");
            return;
        }

        Cab selectedCab = cabs.get(choice - 1);

        // Prompt user to input the number of seats to book
        System.out.print("Enter the number of seats to book: ");
        int requiredSeats = input.nextInt();

        // Input distance and consume the newline character
        System.out.print("Enter the distance in km: ");
        double distance = input.nextDouble();
        input.nextLine();  // Consume the newline character

        // Input destination
        System.out.print("Enter the destination: ");
        String destination = input.nextLine();

        // Attempt to book the selected cab
        if (selectedCab.book(requiredSeats)) {
            System.out.println("Booking confirmed for " + requiredSeats + " seats in " + selectedCab.name);
            System.out.println("Car: " + selectedCab.name + " (" + selectedCab.carVariety + ")");
            System.out.println("Distance: " + distance + "km");
            System.out.println("Destination: " + destination);
        } else {
            System.out.println("Sorry, not enough seats available in " + selectedCab.name);
        }
    }

    @Override
    public String toString() {
        return "OnlineCabBookingSystem []";
    }
}