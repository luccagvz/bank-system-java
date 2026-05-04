package Application;

import entities.Account;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = scan.nextInt();

        System.out.print("Enter account holder: ");
        scan.nextLine();
        String holder = scan.nextLine();

        System.out.print("Is there an initial deposit (y/n) ? ");
        char response = scan.next().charAt(0);

        Account account;

        if (response == 'y' || response == 'Y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = scan.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }

        System.out.println("\nAccount data:");
        System.out.println(account);

        System.out.print("\nEnter a deposit value: ");
        double deposit = scan.nextDouble();

        if (account.deposit(deposit)) {
            System.out.println("Updated account data:");
        } else {
            System.out.println("Invalid deposit!");
        }
        System.out.println(account);

        System.out.println("\nUpdated account data: ");
        System.out.println(account);

        System.out.print("\nEnter a withdraw value: ");
        double withdraw = scan.nextDouble();
        if (account.withdraw(withdraw)) {
            System.out.println("Updated account data:");
        } else {
            System.out.println("Invalid withdraw!");
        }
        System.out.println(account);
        scan.close();
    }
}
