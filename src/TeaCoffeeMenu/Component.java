package TeaCoffeeMenu;

import java.util.ArrayList;

public abstract class Component {
    private float price;
    private String name;
    protected ArrayList<String> suitedTypes;

    Component(float price, String name){
        this.price = price;
        this.name = name;
        suitedTypes = new ArrayList<>();
    }

    public ArrayList<String> getSuitedDrinkTypes() {
        return suitedTypes;
    }

    public float getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Component{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
