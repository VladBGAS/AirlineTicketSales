import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinationManager {
    Connection database;

    public DestinationManager(Connection connection) {
        database = connection;
    }

    public List<Destination> getAllData() throws SQLException {
        List<Destination> destinations = new ArrayList<>();

        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM destinations");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("destination_id");
                String city = result.getString("city_name");
                String airportCode = result.getString("airport_code");

                Destination destination = new Destination(id, city, airportCode);
                destinations.add(destination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return destinations;
    }

    // Method to update an existing destination in the destinations table
    public void update(Destination destination) {
        try {
            PreparedStatement statement = database.prepareStatement("UPDATE destinations SET city_name = ?, airport_code = ? WHERE destination_id = ?");
            statement.setString(1, destination.name);
            statement.setString(2, destination.airportCode);
            statement.setInt(3, destination.id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a specific destination from the destinations table
    public Destination get(int destinationId) {

        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM destinations WHERE id = ?");
            statement.setInt(1, destinationId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("destination_id");
                String name = result.getString("city_name");
                String airportCode = result.getString("airport_code");

                Destination destination = new Destination(id, name, airportCode);
                return destination;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

