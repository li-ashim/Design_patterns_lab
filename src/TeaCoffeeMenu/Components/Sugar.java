package TeaCoffeeMenu.Components;

public class Sugar extends Component {
    static private Sugar instance;
    private double price = 10;
    private final String name = "Сахар";

    private Sugar() {}
    static public Sugar getInstance() {
        if (instance == null) {
            instance = new Sugar();
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
