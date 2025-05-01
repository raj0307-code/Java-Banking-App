import java.util.Scanner;

class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Amount deposited successfully!");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Amount withdrawn successfully!");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.printf(" Current Balance: ₹%.2f\n", balance);
    }

    // Display account info
    public void displayDetails() {
        System.out.println(" Account Holder: " + name);
        System.out.println("f Account Number: " + accountNumber);
        checkBalance();
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Account setup
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your account number: ");
        String accNo = sc.nextLine();

        BankAccount account = new BankAccount(name, accNo);

        int choice;

        do {
            System.out.println("\n------ Banking Menu ------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayDetails();
                    break;
                case 5:
                    System.out.println(" Thank you for using the Banking App!");
                    System.exit(0); // Exit immediately after message
                    break;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }

        } while (true); // Infinite loop will break only on System.exit()

    }
}
