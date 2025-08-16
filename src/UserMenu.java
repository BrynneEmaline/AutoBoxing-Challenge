import java.util.Objects;
import java.util.Scanner;

public class UserMenu {

    Bank bank = new Bank();

    public String startMessage() {
        return """
    ~~~~~~~~~~~~~~~~~~~~~~~~~~
    Banking App Starting Up...
    ~~~~~~~~~~~~~~~~~~~~~~~~~~
    """;
    }

    public void runMenu() {

        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("""
                     What would you like to do?
                     1. Add new user
                     2. Add new transaction
                     3. View all users
                     4. View user transactions
                     5. Exit application
                    """);
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    boolean chooseAnother = true;
                    do {
                        System.out.println("What is the user's name? ");
                        String name = scanner.nextLine();
                        bank.addCustomer(name);

                        String userChoice;
                        while (true) {
                            System.out.println("Enter another user? Y/N");
                            userChoice = scanner.nextLine();

                            if (userChoice.equalsIgnoreCase("Y") || userChoice.equalsIgnoreCase("N")) {
                                break;
                            }
                            System.out.println("Invalid input. Enter Y or N ");
                        }

                        if (userChoice.equalsIgnoreCase("N")) {
                            chooseAnother = false;
                        }
                    } while(chooseAnother);
                }
                case "2" -> {
                    System.out.println("Which user is this transaction for? ");
                    String name = scanner.nextLine();
                    if (bank.userExists(name)) { // add exception handling for non-double responses
                        System.out.println("Is this transaction a withdrawal or deposit? W/D ");
                        String transactionType = scanner.nextLine();
                        System.out.println("How much is the transaction for? ");
                        double amount = scanner.nextDouble();
                        bank.addTransaction(amount, name, transactionType);
                    }
                }
                case "3" -> {
                    bank.listCustomers();
                }
                case "4" -> {
                    System.out.println("What is the user's name? ");
                    String name = scanner.nextLine().trim();
                    bank.printCustomerInfo(name);
                }
                case "5" -> System.out.println("Exiting banking app. ");
                default -> System.out.println("Invalid choice. ");
            }
        } while (!Objects.equals(choice, "5"));
    }
}
