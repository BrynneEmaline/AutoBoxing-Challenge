import java.util.Iterator;

public class Testing {
    public static void main(String[] args) {

        Bank bank = new Bank("Mr.Bank");

        UserMenu userMenu = new UserMenu();
        userMenu.startMessage();
        userMenu.runMenu();

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
