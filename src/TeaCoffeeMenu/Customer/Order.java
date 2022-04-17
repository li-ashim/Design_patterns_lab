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

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
