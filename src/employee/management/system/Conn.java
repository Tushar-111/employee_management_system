package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {

    Connection connection;
    Statement statement;

    public Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "T#1822@tp");
            
            // Create a statement object for executing SQL queries
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            // Handle class not found exception (e.g., driver not found)
            System.err.println("MySQL JDBC driver not found. Make sure the driver is on the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL exception (e.g., connection error)
            System.err.println("SQL error occurred while establishing connection or creating statement.");
            e.printStackTrace();
        }
    }

    // Add methods to close the connection and statement when done
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error while closing the statement or connection.");
            e.printStackTrace();
        }
    }
}
