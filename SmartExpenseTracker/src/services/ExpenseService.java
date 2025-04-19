package services;

import database.DatabaseConnection;
import models.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseService {

    // ✅ Add Expense
    public static boolean addExpense(String category, double amount, Date date, int userId) {
        String query = "INSERT INTO expenses (category, amount, date, user_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, category);
            stmt.setDouble(2, amount);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, userId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Get Expenses of a User
    public static List<Expense> getUserExpenses(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                expenses.add(new Expense(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("date"),
                        rs.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    // ✅ Delete Expense by ID
    public static boolean deleteExpense(int expenseId) {
        String query = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, expenseId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

