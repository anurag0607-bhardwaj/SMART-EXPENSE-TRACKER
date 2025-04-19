package models;

import java.util.Date;

public class Expense {
    private int id;
    private String category;
    private double amount;
    private Date date;
    private int userId;

    public Expense(int id, String category, double amount, Date date, int userId) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    public int getId() { return id; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
    public int getUserId() { return userId; }

    public void setId(int id) { this.id = id; }
    public void setCategory(String category) { this.category = category; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(Date date) { this.date = date; }
    public void setUserId(int userId) { this.userId = userId; }
}
