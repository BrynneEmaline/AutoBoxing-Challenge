import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
    private String name;
    ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(customer.getName())) {
                System.out.println("Customer already in system.");
                break;
            }
        }
        customers.add(customer);
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

    public void printCustomerInfo(Customer customer) {        // print customer name
        // and transaction amounts. method should use unboxing
        // how does it unbox? takes Double wrapper from customer arraylist of transactions
        // and returns a double

    }

}
