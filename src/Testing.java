import java.util.Iterator;

public class Testing {
    public static void main(String[] args) {

        Bank bank = new Bank("Mr.Bank");
        Customer customer1 = new Customer("Fred");
        Customer customer2 = new Customer("Tom");
        Customer customer3 = new Customer("Bill");
        Customer customer4 = new Customer("Jerry");
        Customer customer5 = new Customer("Jerry"); //testing customer is already in the system logic

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);
        bank.addCustomer(customer4);
        bank.addCustomer(customer5);

        bank.getCustomersNames();
        bank.addTransaction(100.0, "Fred");
        System.out.println(customer1.getTransactions());



    }








    /*
    banking application
   with customer and bank type

   customer
   - name
   - array list of transactions containing
   Double wrapper elements
   transactions can be a credit (positive amount)
   or a debit (negative amount)


   bank
   -name
   -array list of customers
   bank should add new customer if not already in list
   should allow customer to add transaction to an existing
   customer
   class should print a statement including customer name
   and transaction amounts. method should use unboxing


     */
}
