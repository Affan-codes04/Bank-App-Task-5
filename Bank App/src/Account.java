import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// Account class to simulate bank operations
public class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with balance: ₹" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited ₹" + amount);
            System.out.println("Amount deposited successfully...");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew ₹" + amount);
            System.out.println("Please collect your cash!");
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Method to return balance
    public double getBalance() {
        return balance;
    }

    // Add entry to transaction history
    private void addTransaction(String detail) {
        String timestamp = new Date().toString();
        transactionHistory.add(timestamp + " - " + detail);
    }

    // Show full transaction history
    public void showTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main method with menu-driven interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ₹");
        double initialBalance = scanner.nextDouble();

        Account acc = new Account(name, initialBalance);

        int choice;
        do {
            System.out.println("\n---- Bank Menu ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    acc.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    acc.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + acc.getBalance());
                    break;

                case 4:
                    acc.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for banking with us. ");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
