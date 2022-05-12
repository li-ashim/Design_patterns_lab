package TeaCoffeeMenu.Drinks;

import TeaCoffeeMenu.Components.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Drink {
    private String type;
    private String name;
    private String manufacturer;
    private double basicPrice;

    public String getType() {
        return type;
    }

    private ArrayList<Component> components;

    public Drink(String type, String name, String manufacturer, double basicPrice) {
        this.type = type;
        this.name = name;
        this.manufacturer = manufacturer;
        this.basicPrice = basicPrice;
        components = new ArrayList<>();
    }

    public void addComponent(Component c) {
        components.add(c);
    }

    public void removeComponent(Component c) {
        components.remove(c);
    }

    public String getFullProductName() {
        return name + " (" + manufacturer + ")";
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public double calculateCost() {
        double totalPrice = basicPrice;
        for (Component c : components) {
            totalPrice += c.getPrice();
        }
        return totalPrice;
    }

    public Drink copy() {
        return new Drink(this.type, this.name,
                this.manufacturer, this.basicPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ").append(basicPrice);
        for (Component c : new HashSet<Component>(components)) {
            sb.append("\t+").append(c).append(" x").append(Collections.frequency(components, c));
        }
        return sb.toString();
    }
}
