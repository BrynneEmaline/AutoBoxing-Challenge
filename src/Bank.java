import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                System.out.println("Customer already in system.");
                return;
            }
        }
        Customer customer = new Customer(name);
        customers.add(customer);
        System.out.println("New user added. ");
    }

    public void removeCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                System.out.println("Customer " + name + "removed.");
            }
        }
        Customer customer = new Customer(name);
        customers.add(customer);
        System.out.println("New user added. ");
    }

    public boolean userExists(String name) {
        for (Customer customer: customers) {
            if (customer.getName().equals(name)) {
                return true;
            }
        }
        System.out.println("Customer not found. ");
        return false;
    }

    public void addTransaction(double amount, String name, String transactionType) {
        if (!customers.isEmpty()) {
            double finalAmount = amount;
            if (transactionType.equalsIgnoreCase("W")) {
                finalAmount = -Math.abs(amount);
            }
            getCustomerByName(name).getTransactions().add(finalAmount);
            System.out.println("transaction added");
        }
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void listCustomers() {
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("All Customers: ");
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
        System.out.println("~~~~~~~~~~~~~~");
    }

    public void printCustomerInfo(String name) {
        if (!userExists(name)) {
            return;
        }

        System.out.println("~~~~~~~~~~~~~~");
        System.out.println(name + "'s transactions: ");
        System.out.println(getCustomerByName(name).getTransactions());
        System.out.println("~~~~~~~~~~~~~~");
    }
}
