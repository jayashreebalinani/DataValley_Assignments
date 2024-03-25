import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class DepartmentDatabase {
    
    private static final String URL = "jdbc:mysql://localhost:3306/departments";
    private static final String USER = "Sree";
    private static final String PASSWORD = "your_password";

  
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {
        Department department = new Department(1, "IT");

        try {
