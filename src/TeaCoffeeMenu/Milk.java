package TeaCoffeeMenu;

public class Milk extends Component{
    private static Milk instance;

    Milk(float price, String name) {
        super(price, name);
    }

    public static Milk getInstance(){
        if(instance == null){
            instance = new Milk(5.99f, "Сахар");
        }
        return instance;
    }
}
