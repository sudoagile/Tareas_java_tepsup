package org.example;

public class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
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
        return balance * interestRate / 100;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}
