import java.sql.*;

public class HealthRecords {
    public static void main(String[] args) {
        try {
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "sreevenkat";
            String password = "venKAT@513"; // Replace with your actual password

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT patient_id, patient_name, condition, cost FROM medical_records")) {

                while (resultSet.next()) {
                    int patientId = resultSet.getInt("patient_id");
                    String name = resultSet.getString("patient_name");
                    String condition = resultSet.getString("condition");
                    double cost = resultSet.getDouble("cost");

                    System.out.println("Patient ID: " + patientId);
                    System.out.println("Name: " + name);
                    System.out.println("Condition: " + condition);
                    System.out.println("Cost: " + cost);
                    System.out.println("---------------------");
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: JDBC driver not found");
        }
    }
}
