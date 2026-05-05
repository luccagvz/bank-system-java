package service;

import entities.Account;

public class AccountService {

    public void deposit(Account account, double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit!");
        }
    }

    public void withdraw(Account account, double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("Invalid withdraw!");
        }
    }

    public void showAccountData(Account account) {
        System.out.println(account);
    }
}