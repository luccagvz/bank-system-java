package application;

import entities.Account;
import service.AccountService;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountService service = new AccountService();

        System.out.print("Enter account number: ");
        int number = scan.nextInt();

        System.out.print("Enter account holder: ");
        scan.nextLine();
        String holder = scan.nextLine();

        System.out.print("Is there an initial deposit (y/n)? ");
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
        service.showAccountData(account);

        int option;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Show account data");
            System.out.println("4 - Exit");
            System.out.print("Option: ");

            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter a deposit value: ");
                    double deposit = scan.nextDouble();
                    service.deposit(account, deposit);
                    break;

                case 2:
                    System.out.print("Enter a withdraw value: ");
                    double withdraw = scan.nextDouble();
                    service.withdraw(account, withdraw);
                    break;

                case 3:
                    service.showAccountData(account);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 4);

        scan.close();
    }
}