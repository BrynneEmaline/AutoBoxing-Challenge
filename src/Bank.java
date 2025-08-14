import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
    private String name;
    ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
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
            if (userExists(name)) {
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

    public void listCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public String toString() {
        return "Customers: " + customers;
    }

    public void printCustomerInfo(String name) {
        System.out.println(name + "'s transactions: ");
        System.out.println(getCustomerByName(name).getTransactions());
        // print customer name
        // and transaction amounts. method should use unboxing
        // how does it unbox? takes Double wrapper from customer arraylist of transactions
        // and returns a double

    }

}
