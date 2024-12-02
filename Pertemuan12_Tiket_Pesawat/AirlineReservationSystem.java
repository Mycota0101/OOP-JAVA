import java.util.Scanner;

// Superclass Ticket
abstract class Ticket {
    protected String passengerName;
    protected double baseFare;

    public Ticket(String passengerName, double baseFare) {
        this.passengerName = passengerName;
        this.baseFare = baseFare;
    }

    // Abstract method to calculate the fare
    public abstract double calculateFare();

    public void displayTicketDetails() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Base Fare: $" + baseFare);
        System.out.println("Total Fare: $" + calculateFare());
    }
}

// Subclass for EconomyTicket
class EconomyTicket extends Ticket {
    private final double discountRate = 0.10;

    public EconomyTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare - (baseFare * discountRate);
    }

    @Override
    public void displayTicketDetails() {
        super.displayTicketDetails();
        System.out.println("Class: Economy");
        System.out.println("Discount Applied: " + (discountRate * 100) + "%");
    }
}

// Subclass for BusinessTicket
class BusinessTicket extends Ticket {
    private final double additionalChargeRate = 0.25;

    public BusinessTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare + (baseFare * additionalChargeRate);
    }

    @Override
    public void displayTicketDetails() {
        super.displayTicketDetails();
        System.out.println("Class: Business");
        System.out.println("Additional Charge: " + (additionalChargeRate * 100) + "%");
    }
}

// Subclass for FirstClassTicket
class FirstClassTicket extends Ticket {
    private final double additionalChargeRate = 0.50;

    public FirstClassTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare + (baseFare * additionalChargeRate);
    }

    @Override
    public void displayTicketDetails() {
        super.displayTicketDetails();
        System.out.println("Class: First Class");
        System.out.println("Additional Charge: " + (additionalChargeRate * 100) + "%");
    }
}

// Main class to run the program
public class AirlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for user input
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter base fare: ");
        double baseFare = scanner.nextDouble();

        System.out.println("Select class (1: Economy, 2: Business, 3: First Class): ");
        int classChoice = scanner.nextInt();

        Ticket ticket;
        switch (classChoice) {
            case 1:
                ticket = new EconomyTicket(passengerName, baseFare);
                break;
            case 2:
                ticket = new BusinessTicket(passengerName, baseFare);
                break;
            case 3:
                ticket = new FirstClassTicket(passengerName, baseFare);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Economy.");
                ticket = new EconomyTicket(passengerName, baseFare);
                break;
        }

        // Display ticket details
        System.out.println("\nTicket Details:");
        ticket.displayTicketDetails();

        scanner.close();
    }
}
