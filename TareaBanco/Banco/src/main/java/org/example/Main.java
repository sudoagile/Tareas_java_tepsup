package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Crear Cuenta de Ahorros");
            System.out.println("2. Crear Cuenta Corriente");
            System.out.println("3. Realizar Operación en una Cuenta");
            System.out.println("4. Mostrar Cuentas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Crear Cuenta de Ahorros
                    System.out.print("Ingrese el saldo inicial: ");
                    double savingsInitialBalance = scanner.nextDouble();
                    System.out.print("Ingrese la tasa de interés: ");
                    double interestRate = scanner.nextDouble();
                    String savingsCode = bank.createSavingsAccount(savingsInitialBalance, interestRate);
                    System.out.println("Cuenta de ahorros creada con el código: " + savingsCode);
                    break;
                case 2:
                    // Crear Cuenta Corriente
                    System.out.print("Ingrese el saldo inicial: ");
                    double currentInitialBalance = scanner.nextDouble();
                    String currentCode = bank.createCurrentAccount(currentInitialBalance);
                    System.out.println("Cuenta corriente creada con el código: " + currentCode);
                    break;
                case 3:
                    // Realizar Operación
                    System.out.print("Ingrese el código de la cuenta: ");
                    String accountCode = scanner.next();
                    Account account = bank.getAccount(accountCode);
                    if (account == null) {
                        System.out.println("Código de cuenta inválido.");
                        break;
                    }

                    System.out.println("Seleccione la operación que desea realizar:");
                    System.out.println("1. Depósito");
                    System.out.println("2. Retiro");
                    System.out.println("3. Calcular Interés");
                    System.out.println("4. Consultar Saldo");
                    System.out.print("Opción: ");
                    int operationOption = scanner.nextInt();

                    double amount = 0;
                    switch (operationOption) {
                        case 1: // Depósito
                            System.out.print("Ingrese el monto a depositar: ");
                            amount = scanner.nextDouble();
                            account.deposit(amount);
                            break;
                        case 2: // Retiro
                            System.out.print("Ingrese el monto a retirar: ");
                            amount = scanner.nextDouble();
                            account.withdraw(amount);
                            break;
                        case 3: // Calcular Interés
                            System.out.println("Interés generado: " + account.calculateInterest());
                            break;
                        case 4: // Consultar Saldo
                            System.out.println("Saldo actual: " + account.getBalance());
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                case 4:
                    // Mostrar Cuentas
                    bank.displayAccounts();
                    break;
                case 5:
                    // Salir
                    System.out.println("Saliendo del sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
