package TeaCoffeeMenu.Components;

public class Sugar extends Component {
    static private Sugar instance;

    private Sugar(String name, double price) {
        super(name, price);
        suitedDrinkTypes.add("чай");
        suitedDrinkTypes.add("кофе");
    }

    static public Sugar getInstance() {
        if (instance == null) {
            instance = new Sugar("сахар", 5);
        }
        return instance;
    }

}
