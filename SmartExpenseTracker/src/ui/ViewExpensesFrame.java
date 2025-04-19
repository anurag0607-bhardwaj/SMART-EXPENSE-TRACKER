package ui;

import models.Expense;
import models.User;
import services.ExpenseService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewExpensesFrame extends JFrame {
    private JTable expenseTable;
    private DefaultTableModel tableModel;
    private JButton deleteButton;

    public ViewExpensesFrame(User user) {
        setTitle("Your Expenses");
        setSize(600, 300);
        setLayout(new BorderLayout());

        // Table columns
        String[] columnNames = {"ID", "Category", "Amount", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        expenseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load user expenses
        loadExpenses(user.getId());

        // Delete button
        deleteButton = new JButton("Delete Selected Expense");
        add(deleteButton, BorderLayout.SOUTH);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = expenseTable.getSelectedRow();
                if (selectedRow != -1) {
                    int expenseId = (int) tableModel.getValueAt(selectedRow, 0);
                    boolean deleted = ExpenseService.deleteExpense(expenseId);
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Expense Deleted!");
                        tableModel.removeRow(selectedRow); // Remove from table
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete expense!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setVisible(true);
    }

    private void loadExpenses(int userId) {
        List<Expense> expenses = ExpenseService.getUserExpenses(userId);
        for (Expense exp : expenses) {
            tableModel.addRow(new Object[]{exp.getId(), exp.getCategory(), exp.getAmount(), exp.getDate()});
        }
    }
}
