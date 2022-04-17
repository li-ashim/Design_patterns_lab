package TeaCoffeeMenu;

import TeaCoffeeMenu.Customer.Customer;
import TeaCoffeeMenu.Drinks.DrinkBuilderDirector;
import TeaCoffeeMenu.Drinks.TeaBuilder;

public class Main {
    public static void main(String[] args) {

        Menu menu = Menu.getInstance();
        DrinkBuilderDirector dbd = DrinkBuilderDirector.getInstance();
        dbd.addDrinkBuilder("чай", new TeaBuilder());

        Customer c = new Customer();
        c.addDrinkToOrder();
        System.out.println(c.makeOrder());
        c.payBill();
    }
}
