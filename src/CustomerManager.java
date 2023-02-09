import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    Connection database;
    public CustomerManager(Connection connection) {
        database = connection;
    }

    public List<Customer> getAllData() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM customers");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("customer_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String address = result.getString("address");
                String phone = result.getString("phone_number");

                Customer customer = new Customer(id, firstName, lastName, address, phone);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Method to update an existing customer in the customers table
    public void update(Customer customer) {
        try {
            PreparedStatement statement = database.prepareStatement("UPDATE customers SET first_name = ?, last_name = ?, addres = ?, phone_number = ? WHERE customer_id = ?");
            statement.setString(1, customer.firstName);
            statement.setString(2, customer.lastName);
            statement.setString(3, customer.address);
            statement.setString(4, customer.phoneNumber);
            statement.setInt(5, customer.id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a specific customer from the customers table
    public Customer get(int customerId) {
        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
            statement.setInt(1, customerId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("customer_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("address");
                String phone = result.getString("phone_number");

                Customer customer = new Customer(id, firstName, lastName, email, phone);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to delete a customer from the customers table
    public void delete(int customerId) {
        try {
            PreparedStatement statement = database.prepareStatement("DELETE FROM customers WHERE id = ?");
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}