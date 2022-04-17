package TeaCoffeeMenu.Customer;

import TeaCoffeeMenu.Components.Component;
import TeaCoffeeMenu.Drinks.Drink;
import TeaCoffeeMenu.Drinks.DrinkBuilder;
import TeaCoffeeMenu.Drinks.DrinkBuilderDirector;
import TeaCoffeeMenu.Menu;

import java.util.HashMap;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private Order order;

    public Customer() {
        order = new Order();
    }

    public void addDrinkToOrder() {
        Menu menu = Menu.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose type of drink (enter number of type): ");
        int i = 1;
        for (String dt : menu.getDrinkTypes()) {
            System.out.print(i + ": ");
            System.out.println(dt);
            ++i;
        }
        String drinkType = menu.getDrinkTypes().get(scanner.nextInt()-1);

        DrinkBuilder db = DrinkBuilderDirector.getInstance().getBuilder(drinkType);

        System.out.println("Choose id of drink: ");
        HashMap<Integer, Drink> typeDrinks = menu.getBasicDrinks(drinkType);
        for (Integer id : typeDrinks.keySet()) {
            System.out.println(id + ": " + typeDrinks.get(id));
        }
        int drinkId = scanner.nextInt();
        db.initialize(drinkId);

        HashMap<Integer, Component> typeComponents = menu.getSuitedComponents(drinkType);
        System.out.println("Add ons:");
        for (Integer cId : typeComponents.keySet()) {
            System.out.println(cId + ": " + typeComponents.get(cId));
        }
        System.out.println("0: Continue");
        int option = scanner.nextInt();
        while (option != 0) {
            db.addComponent(option);
            option = scanner.nextInt();
        }

        order.getItems().add(db.getResult());
        System.out.println(db.getResult() + " added to order.");
        db.reset();
    }
    public Order makeOrder() {
        return order;
    }
    public void payBill() {
        System.out.println("Bill payed: " + order.getTotalCost());
    }
}
