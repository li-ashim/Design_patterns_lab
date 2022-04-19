package TeaCoffeeMenu.Customer;

import TeaCoffeeMenu.Drinks.Drink;

import java.util.ArrayList;

public class Order {
    private ArrayList<Drink> items;

    public Order() {
        items = new ArrayList<>();
    }

    public ArrayList<Drink> getItems() {
        return items;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Drink d : items) {
            totalCost += d.calculateCost();
        }
        return totalCost;
    }

    public void print() {
        System.out.println("\n" + "_".repeat(30));
        System.out.println("Ваш заказ:");
        for (Drink d : items) {
            d.print();
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("_".repeat(30) + "\n");
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
