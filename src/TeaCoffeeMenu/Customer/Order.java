package TeaCoffeeMenu.Customer;

import TeaCoffeeMenu.Drinks.Drink;

import java.util.ArrayList;


public class Order {
    private static int lastOrderNumber = 1;  // numeration is agreed among threads of one process
    private int orderNumber;
    private ArrayList<Drink> items;

    public Order() {
        items = new ArrayList<>();
        orderNumber = lastOrderNumber++;
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
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("_".repeat(30)).append("\n");
        sb.append("Заказ №").append(orderNumber).append("\n");
        for (Drink d : items) {
            sb.append(d).append("\n");
        }
        sb.append("Итого: ").append(getTotalCost()).append("\n");
        sb.append("_".repeat(30));
        return sb.toString();
    }
}
