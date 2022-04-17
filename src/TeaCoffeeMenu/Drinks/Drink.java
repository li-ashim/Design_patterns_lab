package TeaCoffeeMenu.Drinks;

import TeaCoffeeMenu.Components.Component;

import java.util.ArrayList;

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
        return type + " - " + name + " - " + manufacturer;
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
        return "Drink{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", basicPrice=" + basicPrice +
                ", components=" + components +
                '}';
    }
}
