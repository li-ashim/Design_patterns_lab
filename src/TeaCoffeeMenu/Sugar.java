package TeaCoffeeMenu;

public class Sugar extends Component{
    private static Sugar instance;



    private Sugar(float price, String name) {
        super(price, name);
        suitedTypes.add("чай");
        suitedTypes.add("кофе");
    }

    public static Sugar getInstance(){
        if(instance == null){
            instance = new Sugar(5.99f, "Сахар");
        }
        return instance;
    }

}
