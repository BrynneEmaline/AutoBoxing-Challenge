import java.util.Scanner;

public class UserMenu {

    Bank bank = new Bank("bank");

    public String startMessage() {
        return "Welcome to the banking app.";
    }

    public void runMenu() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.print("""
                     What would you like to do?
                     1. Add new user
                     2. Add new transaction
                     3. View all users
                     4. View user transactions
                     5. Exit application
                    """);

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("What is the user's name? ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    bank.addCustomer(name);
                }
                case 2 -> {
                    System.out.println("Which user is this transaction for? ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    if (bank.userExists(name)) { // add exception handling for non-double responses
                        System.out.println("Is this transaction a withdrawal or deposit? W/D ");
                        String transactionType = scanner.nextLine();
                        System.out.println("How much is the transaction for? ");
                        double amount = scanner.nextDouble();
                        bank.addTransaction(amount, name, transactionType);
                    }
                }
                case 3 -> {
                    bank.listCustomers();
                }
                case 4 -> {
                    System.out.println("What is the user's name? ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    bank.printCustomerInfo(name);
                }
                case 5 -> System.out.println("Exiting banking app. ");
                default -> System.out.println("Invalid choice. ");
            }
        } while (choice != 5);
    }
}
