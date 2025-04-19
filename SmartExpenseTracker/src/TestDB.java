import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SmartExpenseTracker"; // Replace 'your_database' with your actual DB name
        String user = "root"; // Change if necessary
        String password = "Aditya514@"; // Your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database is working fine! ✅");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found! ❌");
        } catch (SQLException e) {
            System.out.println("Database connection failed! ❌");
            e.printStackTrace();
        }
    }
}
