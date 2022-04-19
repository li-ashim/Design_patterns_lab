package TeaCoffeeMenu;

public class DirectorBuilders {

    private static DirectorBuilders instance;

    private DirectorBuilders(){};
    public static DirectorBuilders getInstance(){
        if(instance == null){
            instance = new DirectorBuilders();
        }
        return instance;
    }

    public void makeDrink(IBuilder builder, Drink d){
        builder.reset();
        builder.initialize(d);
        builder.addComponent();
    }
}
