package application;

import entities.Account;
import service.AccountService;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountService service = new AccountService();

        int option;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Create account");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Show account");
            System.out.println("5 - Exit");
            System.out.print("Option: ");

            option = scan.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Enter account number: ");
                    int number = scan.nextInt();

                    System.out.print("Enter account holder: ");
                    scan.nextLine();
                    String holder = scan.nextLine();

                    System.out.print("Initial deposit (y/n)? ");
                    char resp = scan.next().charAt(0);

                    boolean created;

                    if (resp == 'y' || resp == 'Y') {
                        System.out.print("Initial deposit value: ");
                        double initial = scan.nextDouble();
                        created = service.createAccount(number, holder, initial);
                    } else {
                        created = service.createAccount(number, holder, null);
                    }

                    if (created) {
                        System.out.println("Account created!");
                    } else {
                        System.out.println("Account already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depNum = scan.nextInt();

                    System.out.print("Deposit value: ");
                    double dep = scan.nextDouble();

                    if (service.deposit(depNum, dep)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid deposit or account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int witNum = scan.nextInt();

                    System.out.print("Withdraw value: ");
                    double wit = scan.nextDouble();

                    if (service.withdraw(witNum, wit)) {
                        System.out.println("Withdraw successful!");
                    } else {
                        System.out.println("Invalid withdraw or account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int showNum = scan.nextInt();

                    Account acc = service.getAccount(showNum);

                    if (acc != null) {
                        System.out.println(acc);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 5);

        scan.close();
    }
}