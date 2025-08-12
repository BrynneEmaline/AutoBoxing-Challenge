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
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                System.out.println("Customer already in system.");
                return;
            }
        }
        Customer customer = new Customer(name);
        customers.add(customer);
        System.out.println("New user added. ");
    }

    public void addTransaction(double amount, String name) {
        for (Customer value : customers) {
            if (value.getName().equals(name)) {
                value.getTransactions().add(amount);
                return;
            }
        }
        System.out.println("Customer not found");
    }

    public void getCustomersNames() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public String toString() {
        return "Customers: " + customers;
    }

    public void printCustomerInfo(String name) {        // print customer name
        // and transaction amounts. method should use unboxing
        // how does it unbox? takes Double wrapper from customer arraylist of transactions
        // and returns a double

    }

}
