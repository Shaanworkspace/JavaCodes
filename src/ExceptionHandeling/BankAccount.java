package ExceptionHandeling;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalException extends Exception {
    public InsufficientBalException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    Scanner sc = new Scanner(System.in);
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalException {
        if (amount > balance) {
            throw new InsufficientBalException("Transaction failed: Insufficient funds. Your balance is ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: ₹" + balance);
    }

    public void addBalance(double amount) throws InsufficientBalException {
        if (amount > 10000) {
            throw new InsufficientBalException("You can't add more that 10,000 as you balance is:  ₹" + balance);
        }
        balance += amount;
        while (balance > 10000) {
            System.out.println("Please Do not add amount which can make you bank Balance more than 10,000 so your balance is:  ₹" + balance);
            balance -= amount;
            System.out.print("Please Enter the amount again : ");
            amount=sc.nextInt();
            balance += amount;
        }
        System.out.println("Added successful! Actual balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class BankWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial Balance : ");
        int balance=0;
        try {
            balance = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        while(balance<10000){
            System.out.print("Please enter balance greater than 10,000 : ");
            balance = sc.nextInt();
        }
        BankAccount account = new BankAccount(balance);

        System.out.println("Welcome to Shaan Bank");
        System.out.println("Current balance: ₹" + account.getBalance());
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        try {
            account.withdraw(amount);
        } catch (InsufficientBalException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter amount to add: ₹");
        double amount1 = sc.nextDouble();
        try {
            account.addBalance(amount1);
        } catch (InsufficientBalException e) {
            System.out.println(e.getMessage());
        }


    }
}
