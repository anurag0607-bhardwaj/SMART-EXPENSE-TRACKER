package ui;

import models.User;
import services.ExpenseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddExpenseFrame extends JFrame {
    private JTextField categoryField, amountField;
    private JButton submitButton;

    public AddExpenseFrame(User user) {
        setTitle("Add Expense");
        setSize(800, 600);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Category:"));
        categoryField = new JTextField();
        add(categoryField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        submitButton = new JButton("Add Expense");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = categoryField.getText();
                double amount = Double.parseDouble(amountField.getText());

                boolean success = ExpenseService.addExpense(category, amount, new Date(), user.getId());
                if (success) {
                    JOptionPane.showMessageDialog(null, "Expense Added Successfully!");
                    dispose(); // Close the window
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add expense!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
