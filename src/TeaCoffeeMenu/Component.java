package TeaCoffeeMenu;

public abstract class Component {
    private float price;
    private String name;

    Component(float price, String name){
        this.price = price;
        this.name = name;
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
