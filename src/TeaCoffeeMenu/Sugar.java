package TeaCoffeeMenu;

public class Sugar extends Component{
    private static Sugar instance;

    Sugar(float price, String name) {
        super(price, name);
    }

    public static Sugar getInstance(){
        if(instance == null){
            instance = new Sugar(5.99f, "Сахар");
        }
        return instance;
    }

}
