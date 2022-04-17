package TeaCoffeeMenu;

import TeaCoffeeMenu.Components.Component;
import TeaCoffeeMenu.Components.Sugar;
import TeaCoffeeMenu.Drinks.Drink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private static Menu instance;
    private static DatabaseDummy db;
    private Menu() {}
    public static Menu getInstance() {
        if (instance == null) {
            db = DatabaseDummy.getInstance();
            instance = new Menu();
        }
        return instance;
    }

    public ArrayList<String> getDrinkTypes() {
        return db.getDrinkTypes();
    }

    public HashMap<Integer, Drink> getBasicDrinks() {
        return db.getBasicDrinks();
    }

    public HashMap<Integer, Drink> getBasicDrinks(String drinkType) {
        return db.getBasicDrinks(drinkType);
    }

    public HashMap<Integer, Component> getComponents() {
        return db.getComponents();
    }

    public HashMap<Integer, Component> getSuitedComponents(String drinkType) { return db.getSuitedComponents(drinkType); }

    public void addDrink(Drink d) {
        db.addBasicDrink(d);
    }

    public void addComponent(Component c) {
        db.addComponent(c);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "basicDrinks=" + db.getBasicDrinks() +
                ", components=" + db.getComponents() +
                '}';
    }
}


class DatabaseDummy {
    private static DatabaseDummy instance;

    private ArrayList<String> drinkTypes;
    private HashMap<Integer, Drink> basicDrinks;
    private HashMap<Integer, Component> components;

    private DatabaseDummy() {
        drinkTypes = new ArrayList<>();
        basicDrinks = new HashMap<>();
        components = new HashMap<>();

        drinkTypes.add("чай");
        drinkTypes.add("кофе");

        basicDrinks.put(1, new Drink("чай", "чёрный", "вкусный чай", 50));
        basicDrinks.put(2, new Drink("чай", "зелёный", "вкусный чай", 55));
        basicDrinks.put(3, new Drink("чай", "чёрный", "чай-чай", 45));

        components.put(1, Sugar.getInstance());
    }
    public static DatabaseDummy getInstance() {
        if (instance == null) {
            instance = new DatabaseDummy();
        }
        return instance;
    }

    public ArrayList<String> getDrinkTypes() {
        return drinkTypes;
    }

    public void addDrinkType(String t) {
        drinkTypes.add(t);
    }

    public HashMap<Integer, Drink> getBasicDrinks() {
        return basicDrinks;
    }

    public HashMap<Integer, Drink> getBasicDrinks(String drinkType) {
        HashMap<Integer, Drink> result = new HashMap<>();
        for (Integer id : basicDrinks.keySet()) {
            if (basicDrinks.get(id).getType() == drinkType) {
                result.put(id, basicDrinks.get(id));
            }
        }
        return result;
    }

    public HashMap<Integer, Component> getSuitedComponents(String drinkType) {
        HashMap<Integer, Component> result = new HashMap<>();
        for (Integer id : components.keySet()) {
            if (components.get(id).getSuitedDrinkTypes().contains(drinkType)) {
                result.put(id, components.get(id));
            }
        }
        return result;
    }

    public void addBasicDrink(Drink d) {
        basicDrinks.put(basicDrinks.size()+1, d);
    }

    public HashMap<Integer, Component> getComponents() {
        return components;
    }

    public void addComponent(Component c) {
        components.put(components.size()+1, c);
    }
}
