import java.util.*;

class ATM {
    private double balance;
    private List<String> transactionHistory;
    private String pin;

    public ATM(String initialPin) {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.pin = initialPin;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void checkBalance() {
        System.out.printf("Current Balance: ₹%.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    public void transferFunds(double amount, ATM receiver) {
        if (amount <= 0) {
            System.out.println("Invalid amount to transfer!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance for transfer!");
        } else {
            balance -= amount;
            receiver.balance += amount;
            addTransaction("Transferred ₹" + amount + " to another account");
            receiver.addTransaction("Received ₹" + amount + " from another account");
            System.out.println("Successfully transferred ₹" + amount);
        }
    }

    public void changePin(String newPin) {
        if (newPin.length() != 4) {
            System.out.println("PIN must be 4 digits.");
            return;
        }
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("All Transactions:");
            for (String txn : transactionHistory) {
                System.out.println("- " + txn);
            }
        }
    }

    public void showMiniStatement() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Last 5 Transactions:");
            int start = Math.max(0, transactionHistory.size() - 5);
            for (int i = start; i < transactionHistory.size(); i++) {
                System.out.println("- " + transactionHistory.get(i));
            }
        }
    }

    public void clearHistory() {
        transactionHistory.clear();
        System.out.println("Transaction history cleared.");
    }

    private void addTransaction(String txn) {
        transactionHistory.add(txn);
    }
}

public class ATMInterface {
    private static final String USER_ID = "user123";
    private static final String USER_PIN = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM userATM = new ATM(USER_PIN);
        ATM dummyReceiver = new ATM("9999"); // Simulated second account

        System.out.println("===== Welcome to Enhanced ATM Interface =====");

        // Authentication
        System.out.print("Enter User ID: ");
        String enteredUserId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (!enteredUserId.equals(USER_ID) || !userATM.validatePin(enteredPin)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        System.out.println("Login successful!");

        int choice;

        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transfer Funds");
            System.out.println("7. Change PIN");
            System.out.println("8. Clear Transaction History");
            System.out.println("9. Exit");

            System.out.print("Choose an option: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userATM.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userATM.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userATM.withdraw(withdrawAmount);
                    break;
                case 4:
                    userATM.showTransactionHistory();
                    break;
                case 5:
                    userATM.showMiniStatement();
                    break;
                case 6:
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = scanner.nextDouble();
                    userATM.transferFunds(transferAmount, dummyReceiver);
                    break;
                case 7:
                    System.out.print("Enter new 4-digit PIN: ");
                    String newPin = scanner.next();
                    userATM.changePin(newPin);
                    break;
                case 8:
                    userATM.clearHistory();
                    break;
                case 9:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
