import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static DatabaseManager databaseManager;

    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = new DatabaseManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Resource Catalog Application");
        int choice = 0;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. See all flight");
            System.out.println("2. Create new flight");
            System.out.println("3. Update a flight");

            System.out.println("4. Get all destination");
            System.out.println("5. Add a new destination");
            System.out.println("6. Update a destination");

            System.out.println("7. List all users");
            System.out.println("8. Add a new user");
            System.out.println("9. Update a user");

            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    var flights = databaseManager.FlightManager.getAllData();
                    for (Flight flight : flights) {
                        System.out.println(flight);
                        System.out.println("---------");
                    }
                    break;
                case 2:
                    // code to create new flight
                    break;
                case 3:
                    // code to update a flight
                    break;
                case 4:
                    var destinations = databaseManager.DestinationManager.getAllData();
                    for (Destination destination : destinations) {
                        System.out.println(destination);
                        System.out.println("---------");
                    }
                    break;
                case 5:
                    // code to get all destinations
                    break;
                case 6:
                    // code to add a new destination
                    break;
                case 7:
                     var users = databaseManager.CustomerManager.getAllData();
                    for (Customer customer : users) {
                        System.out.println(customer);
                        System.out.println("---------");
                    }
                    break;
                case 8:
                    // code to add a new user
                    break;
                case 9:
                    // code to update a user
                    break;
                case 10:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
            }
        } while (choice != 16);

    }


}