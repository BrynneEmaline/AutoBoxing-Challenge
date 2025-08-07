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
            iterator.next();
            if (iterator.next().getName().equals(customer.getName())) {
                System.out.println("Customer already in system.");
                break;
            }
        }
        customers.add(customer);
    }

    public void addTransaction(Double amount) {
        // adds amount given to arraylist of transactions in customer

    }

    public void printCustomerInfo(Customer customer) {
        // print customer name
        // and transaction amounts. method should use unboxing
        // how does it unbox? takes Double wrapper from customer arraylist of transactions
        // and returns a double

    }

}
