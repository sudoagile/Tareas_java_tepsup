package org.example;

public class CurrentAccount implements Account {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // Cuentas corrientes usualmente no generan intereses
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "balance=" + balance +
                '}';
    }
}
