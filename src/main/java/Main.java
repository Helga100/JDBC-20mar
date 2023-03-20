import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirportServiceRequest airportServiceRequest = new AirportServiceRequest();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please enter: 1 - SummarizeTotalPassengerToService, 2 - Crete Table, " +
                    "3 - Insert Passengers, 4-Read all passengers, 5- update passenger age, 6-Delete passenger 0 - Exit.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    airportServiceRequest.summarizeTotalPassengerToService();
                    break;
                case 2:
                    airportServiceRequest.createTable();
                    break;
                case 3:
                    airportServiceRequest.insertPassengers();
                    break;
                case 4:
                    airportServiceRequest.readAllPassengers();
                    break;
                case 5:
                    airportServiceRequest.updatePassengerAge();
                    break;
                case 6:
                    airportServiceRequest.deletePassenger();
                    break;
                case 0:
                    System.out.println("Exit the program");
                    break;
                default:
                    System.out.println("Please enter correct choice");
            }
        } while (choice != 0);
    }
}





