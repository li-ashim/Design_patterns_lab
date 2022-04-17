package TeaCoffeeMenu.Drinks;

import java.util.HashMap;

public class DrinkBuilderDirector {
    static private DrinkBuilderDirector instance;
    private HashMap<String, DrinkBuilder> dbs;
    private DrinkBuilderDirector() {
        dbs = new HashMap<>();
    }

    static public DrinkBuilderDirector getInstance() {
        if (instance == null) {
            instance = new DrinkBuilderDirector();
        }
        return instance;
    }

    public void addDrinkBuilder(String type, DrinkBuilder db) {
        dbs.put(type, db);
    }

    public DrinkBuilder getBuilder(String type) {
        return dbs.get(type);
    }
}
