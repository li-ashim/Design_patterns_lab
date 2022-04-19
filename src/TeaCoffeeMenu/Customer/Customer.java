package TeaCoffeeMenu.Customer;

import TeaCoffeeMenu.Components.Component;
import TeaCoffeeMenu.Drinks.Drink;
import TeaCoffeeMenu.Drinks.DrinkBuilder;
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

        System.out.println("\nВиды напитков");
        int i = 1;
        for (String dt : menu.getDrinkTypes()) {
            System.out.print("\t" + i + ": ");
            System.out.println(dt);
            ++i;
        }
        System.out.print("Выберите вид напитка (введите номер напитка): ");
        String drinkType = menu.getDrinkTypes().get(scanner.nextInt()-1);

        DrinkBuilder db = DrinkBuilder.getInstance();

        System.out.println("\n" + drinkType + ":");
        HashMap<Integer, Drink> typeDrinks = menu.getBasicDrinks(drinkType);
        for (Integer id : typeDrinks.keySet()) {
            System.out.print("\t" + id + ": ");
            typeDrinks.get(id).print();
        }
        System.out.print("Выберите напиток (введите номер напитка): ");
        int drinkId = scanner.nextInt();
        db.initialize(drinkId);

        HashMap<Integer, Component> typeComponents = menu.getSuitedComponents(drinkType);

        int option;
        while (true) {
            System.out.println("\nДополнительно:");
            for (Integer cId : typeComponents.keySet()) {
                System.out.println("\t" + cId + ": " + typeComponents.get(cId));
            }
            System.out.println("\t0: Продолжить");
            System.out.print("Выберите доп. компонетны: ");

            option = scanner.nextInt();
            if (option == 0) {
                break;
            }

            if (option != 0) {
                System.out.println("\nДоп. " + typeComponents.get(option));
                System.out.println("\t" + 1 + ": добавить");
                System.out.println("\t" + 2 + ": удалить");
                System.out.println("\t" + 0 + ": отменить");

                System.out.print("Выберите действие: ");
                int controlOption = scanner.nextInt();
                while (controlOption != 0) {
                    if (controlOption == 1) {
                        System.out.println("Доп. " + typeComponents.get(option) + " добавлен");
                        db.addComponent(option);
                    } else {
                        System.out.println("Доп. " + typeComponents.get(option) + " удален");
                        db.removeComponent(option);
                    }
                    System.out.print("Выберите действие: ");
                    controlOption = scanner.nextInt();
                }
            }
        }

        order.getItems().add(db.getResult());

        System.out.println("Элемент добавлен в заказ.");
        db.getResult().print();
        db.reset();
    }
    public Order makeOrder() {
        order.print();
        return order;
    }
    public void payBill() {
        System.out.println("Счёт оплачен: " + order.getTotalCost());
    }
}
