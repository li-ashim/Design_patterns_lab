package TeaCoffeeMenu;

import java.util.HashMap;
import java.util.Scanner;

public class Customer {
    private long id;
    private String name;
    private Order order;
    private DirectorBuilders dr;

    public Customer(String name) {
        this.id = (long) (Math.random() * 2 * Long.MAX_VALUE - Long.MAX_VALUE);
        this.name = name;
        order = new Order();
        dr = DirectorBuilders.getInstance();
    }


    /*добавление напитка в заказ*/
    public void addDrinkToOrder(){
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

        DrinkBuilder db = DrinkBuilder.getInstance();

        System.out.println("Choose id of drink: ");
        HashMap<Integer, Drink> typeDrinks = menu.getBasicDrinks(drinkType);
        for (Integer j : typeDrinks.keySet()) {
            System.out.println(j + ": " + typeDrinks.get(j));
        }
        int drinkId = scanner.nextInt();

        dr.makeDrink(db, typeDrinks.get(drinkId));

        order.addDrink(db.getResult());

        System.out.println(db.getResult() + " added to order.");
    }

    public void getOrder(){
        System.out.println(order);
    }

    /*Оформление заказа*/
    public Order makeOrder(){
        System.out.println("заказ сделан");
        return order;
    }

    /*оплата заказа*/
    public void payBill(){
        System.out.println("заказ оплачен");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
