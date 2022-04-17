package TeaCoffeeMenu;

import TeaCoffeeMenu.Customer.Customer;

public class Main {
    public static void main(String[] args) {

        Menu menu = Menu.getInstance();

        Customer c = new Customer();
        c.addDrinkToOrder();
        System.out.println(c.makeOrder());
        c.payBill();
    }
}
