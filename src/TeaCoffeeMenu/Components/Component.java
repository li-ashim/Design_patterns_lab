package TeaCoffeeMenu.Components;

import java.util.ArrayList;

public abstract class Component {
    protected String name;
    protected double price;
    protected ArrayList<String> suitedDrinkTypes;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
        suitedDrinkTypes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    public ArrayList<String> getSuitedDrinkTypes() {
        return suitedDrinkTypes;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
