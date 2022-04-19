package TeaCoffeeMenu;

import TeaCoffeeMenu.Customer.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = Menu.getInstance();

        Customer c = new Customer();
        c.addDrinkToOrder();
        c.makeOrder();
        c.payBill();
    }
}
