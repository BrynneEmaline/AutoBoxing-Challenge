import java.util.InputMismatchException;
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
                     5. Remove a user
                     6. Exit application
                    """);
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    boolean chooseAnother = true;
                    do {
                        System.out.println("What is the user's name? ");
                        String name = scanner.nextLine().trim();
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
                    boolean chooseAnother = true;
                    do {
                        if (bank.getCustomers().isEmpty()) {
                            System.out.println("There are no customers currently in the system. ");
                            System.out.println();
                            break;
                        }

                        System.out.println("Which user is this transaction for? ");
                        String name = scanner.nextLine();

                        if (bank.userExists(name)) {
                            String transactionType;
                            while (true) {
                                System.out.println("Is this transaction a withdrawal or deposit? W/D ");
                                 transactionType = scanner.nextLine();
                                if (transactionType.equalsIgnoreCase("W") || transactionType.equalsIgnoreCase("D")) {
                                    break;
                                }
                                System.out.println("Invalid input. Enter W or D ");
                            }

                            double amount = 0;
                            while (true) {
                                System.out.println("How much is the transaction for? ");
                                try {
                                    amount = scanner.nextDouble();
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a numerical amount.");
                                    scanner.nextLine();
                                }
                            }
                                bank.addTransaction(amount, name, transactionType);
                        } else {
                            break;
                        }
                        String userChoice;
                        while (true) {
                            System.out.println("Enter another transaction? Y/N");
                            userChoice = scanner.nextLine();

                            if (userChoice.equalsIgnoreCase("Y") || userChoice.equalsIgnoreCase("N")) {
                                break;
                            }
                            System.out.println("Invalid input. Enter Y or N ");
                        }

                        if (userChoice.equalsIgnoreCase("N")) {
                            chooseAnother = false;
                        }
                    } while (chooseAnother);
                }

                case "3" -> {
                    if (bank.getCustomers().isEmpty()) {
                        System.out.println("There are no customers currently in the system. ");
                        System.out.println();
                        break;
                    }
                    bank.listCustomers();
                }

                case "4" -> {
                    if (bank.getCustomers().isEmpty()) {
                        System.out.println("There are no customers currently in the system. ");
                        System.out.println();
                        break;
                    }

                    System.out.println("What is the user's name? ");
                    String name = scanner.nextLine().trim();

                    if (bank.getCustomerByName(name).getTransactions().isEmpty()) {
                        System.out.println("Customer has no transactions. ");
                        break;
                    }
                    bank.printCustomerInfo(name);
                }

                case "5" -> {
                    if (bank.getCustomers().isEmpty()) {
                        System.out.println("There are no customers currently in the system. ");
                        System.out.println();
                        break;
                    }

                    System.out.println("What is the user's name? ");
                    String name = scanner.nextLine().trim();


                }
                case "6" -> System.out.println("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~
                Exiting banking app...
                ~~~~~~~~~~~~~~~~~~~~~~~~~~
                """);
                default -> System.out.println("Invalid choice. ");
            }
        } while (!Objects.equals(choice, "6"));
    }
}
