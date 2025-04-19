package ui;

import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFrame extends JFrame {
    private User user;

    public DashboardFrame(User user) {
        this.user = user;
        setTitle("Expense Tracker Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername() + "!", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // ✅ Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns

        JButton addExpenseButton = new JButton("Add Expense");
        JButton viewExpensesButton = new JButton("View Expenses");

        buttonPanel.add(addExpenseButton);
        buttonPanel.add(viewExpensesButton);

        add(buttonPanel, BorderLayout.CENTER);

        // ✅ ActionListener for Add Expense
        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddExpenseFrame(user); // Open Add Expense Window
            }
        });

        // ✅ ActionListener for View Expenses
        viewExpensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewExpensesFrame(user); // Open View Expenses Window
            }
        });

        setVisible(true);
    }
}


