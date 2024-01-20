package org.example;

import java.util.*;

public class Bank {
    private Map<String, Account> accountsMap;

    public Bank() {
        accountsMap = new HashMap<>();
    }

    private String generateAccountCode() {
        Random random = new Random();
        String code;
        do {
            code = String.format("%04d", random.nextInt(10000));
        } while (accountsMap.containsKey(code));
        return code;
    }

    public String createSavingsAccount(double initialBalance, double interestRate) {
        String code = generateAccountCode();
        SavingsAccount account = new SavingsAccount(initialBalance, interestRate);
        accountsMap.put(code, account);
        return code;
    }

    public String createCurrentAccount(double initialBalance) {
        String code = generateAccountCode();
        CurrentAccount account = new CurrentAccount(initialBalance);
        accountsMap.put(code, account);
        return code;
    }

    public Account getAccount(String code) {
        return accountsMap.get(code);
    }

    public void performOperation(String code, String operation, double amount) {
        Account account = getAccount(code);
        if (account == null) {
            System.out.println("Código de cuenta inválido.");
            return;
        }

        switch (operation.toLowerCase()) {
            case "deposit":
                account.deposit(amount);
                break;
            case "withdraw":
                account.withdraw(amount);
                break;
            case "interest":
                System.out.println("Calculated Interest: " + account.calculateInterest());
                break;
            case "balance":
                System.out.println("Current Balance: " + account.getBalance());
                break;
            default:
                System.out.println("Operación desconocida.");
        }
    }

    public void displayAccounts() {
        for (Map.Entry<String, Account> entry : accountsMap.entrySet()) {
            System.out.println("Código: " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
