package ui;

import models.User;
import services.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton; // Added registerButton

    public LoginFrame() {
        setTitle("Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2)); // Increased rows from 3 to 4

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register"); // Added Register button

        add(loginButton);
        add(registerButton); // Adding Register button to UI

        // Login Action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                User user = UserService.loginUser(username, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose();
                    new DashboardFrame(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!");
                }
            }
        });

        // Register Action - Opens the Register Frame
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close Login window
                new RegisterFrame(); // Open Register window
            }
        });

        setVisible(true);
    }
}
