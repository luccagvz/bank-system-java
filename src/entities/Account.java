package entities;

public class Account {

    private static final double WITHDRAW_FEE = 5.0;

    private final int accountNumber;
    private String holder;
    private double balance;

    public Account(int accountNumber, String holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
    }

    public Account(int accountNumber, String holder, double initialDeposit) {
        this(accountNumber, holder);
        deposit(initialDeposit);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount + WITHDRAW_FEE > balance) return false;
        balance -= amount + WITHDRAW_FEE;
        return true;
    }

    @Override
    public String toString() {
        return "Account "
                + accountNumber
                + ", Holder: "
                + holder
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}