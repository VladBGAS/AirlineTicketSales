import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    Connection database;

    public FlightManager(Connection connection) {
        database = connection;
    }

    public List<Flight> getAllData() throws SQLException {
        List<Flight> flights = new ArrayList<>();

        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM flights");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("flight_id");
                String flightNumber = result.getString("flight_number");
                String departureTime = result.getString("departure_time");
                String arrivalTime = result.getString("arrival_time");
                int availableSeats = result.getInt("available_seats");
                int airline_id = result.getInt("airline_id");
                int destination_id = result.getInt("destination_id");

                Flight flight = new Flight(id, flightNumber, departureTime, arrivalTime, availableSeats, airline_id, destination_id);
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    // Method to update an existing flight in the flights table
    public void update(Flight flight) {
        try {
            PreparedStatement statement = database.prepareStatement("UPDATE flights SET flight_number = ?, departure_time = ?, arrival_time = ?, available_seats = ?, airline_id = ?, destination_id = ? WHERE id = ?");
            statement.setString(1, flight.flightNumber);
            statement.setString(2, flight.departureTime);
            statement.setString(3, flight.arrivalTime);
            statement.setInt(4, flight.availableSeats);
            statement.setInt(5, flight.airlineId);
            statement.setInt(6, flight.destinationId);
            statement.setInt(7, flight.id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a specific flight from the flights table
    public Flight get(int flightId) {
        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM flights WHERE id = ?");
            statement.setInt(1, flightId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String flightNumber = result.getString("flight_number");
                String departureTime = result.getString("departure_time");
                String arrivalTime = result.getString("arrival_time");
                int availableSeats = result.getInt("available_seats");
                int airline_id = result.getInt("airline_id");
                int destination_id = result.getInt("destination_id");

                Flight flight = new Flight(id, flightNumber, departureTime, arrivalTime, availableSeats, airline_id, destination_id);
                return flight;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


