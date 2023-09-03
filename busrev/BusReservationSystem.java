package busrev;
import java.util.Scanner;
public class BusReservationSystem {
	  private static int totalSeats = 10;
	    private static boolean[] seats = new boolean[totalSeats];

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Bus Reservation System");
	            System.out.println("1. View Available Seats");
	            System.out.println("2. Reserve a Seat");
	            System.out.println("3. Cancel Reservation");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    viewAvailableSeats();
	                    break;
	                case 2:
	                    reserveSeat(scanner);
	                    break;
	                case 3:
	                    cancelReservation(scanner);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the Bus Reservation System!");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void viewAvailableSeats() {
	        System.out.println("Available Seats:");
	        for (int i = 0; i < totalSeats; i++) {
	            if (!seats[i]) {
	                System.out.println("Seat " + (i + 1));
	            }
	        }
	    }

	    private static void reserveSeat(Scanner scanner) {
	        viewAvailableSeats();
	        System.out.print("Enter the seat number you want to reserve: ");
	        int seatNumber = scanner.nextInt();

	        if (seatNumber < 1 || seatNumber > totalSeats) {
	            System.out.println("Invalid seat number. Please try again.");
	        } else if (seats[seatNumber - 1]) {
	            System.out.println("Seat " + seatNumber + " is already reserved.");
	        } else {
	            seats[seatNumber - 1] = true;
	            System.out.println("Seat " + seatNumber + " has been reserved.");
	        }
	    }

	    private static void cancelReservation(Scanner scanner) {
	        viewAvailableSeats();
	        System.out.print("Enter the seat number you want to cancel the reservation for: ");
	        int seatNumber = scanner.nextInt();

	        if (seatNumber < 1 || seatNumber > totalSeats) {
	            System.out.println("Invalid seat number. Please try again.");
	        } else if (!seats[seatNumber - 1]) {
	            System.out.println("Seat " + seatNumber + " is not reserved.");
	        } else {
	            seats[seatNumber - 1] = false;
	            System.out.println("Reservation for seat " + seatNumber + " has been canceled.");
	        }
	    }
	}

