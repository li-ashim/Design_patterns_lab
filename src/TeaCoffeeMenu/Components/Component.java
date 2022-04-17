package TeaCoffeeMenu.Components;

public abstract class Component {
    private String name;
    private double price;

    abstract public String getName();
    abstract public double getPrice();

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
