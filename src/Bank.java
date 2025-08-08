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

    public void addTransaction(double amount, Customer customer) {
        for (Customer value : customers) {
            if (value.getName().equals(customer.getName())) {
                customer.getTransactions().add(amount);
            }
            System.out.println("Customer not found");
        }


        // adds amount given to arraylist of transactions in customer

    }

    public ArrayList<Customer> getCustomers() {
        return customers;
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
