package service;

import entities.Account;
import java.util.ArrayList;

public class AccountService {

    private ArrayList<Account> accounts = new ArrayList<>();

    public boolean createAccount(int number, String holder, Double initialDeposit) {

        if (findAccount(number) != null) {
            return false;
        }

        Account acc;

        if (initialDeposit != null) {
            acc = new Account(number, holder, initialDeposit);
        } else {
            acc = new Account(number, holder);
        }

        accounts.add(acc);
        return true;
    }

    public Account findAccount(int number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == number) {
                return acc;
            }
        }
        return null;
    }

    public boolean deposit(int number, double amount) {
        Account acc = findAccount(number);

        if (acc == null) return false;

        return acc.deposit(amount);
    }

    public boolean withdraw(int number, double amount) {
        Account acc = findAccount(number);

        if (acc == null) return false;

        return acc.withdraw(amount);
    }

    public Account getAccount(int number) {
        return findAccount(number);
    }
}