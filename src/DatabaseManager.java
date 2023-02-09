import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public DestinationManager DestinationManager;
    public CustomerManager CustomerManager;
    public FlightManager FlightManager;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AirlineTicketSales";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "rootroot";

    public DatabaseManager() {
        Connection conn = createConnection();
        DestinationManager = new DestinationManager(conn);
        CustomerManager = new CustomerManager(conn);
        FlightManager = new FlightManager(conn);
    }

    private Connection createConnection() {
        try {
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
