package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseDummy {
    private static DatabaseDummy instance;

    private ArrayList<String> drinkTypes;
    private HashMap<Integer, Drink> basicDrinks;
    private HashMap<Integer, Component> components;
    private ArrayList<String> drinkSize;

    private DatabaseDummy() {
        drinkTypes = new ArrayList<>();
        drinkSize = new ArrayList<String>();
        basicDrinks = new HashMap<>();
        components = new HashMap<>();

        drinkTypes.add("чай");
        drinkTypes.add("кофе");

        drinkSize.add("0.2");
        drinkSize.add("0.4");
        drinkSize.add("0.5");

        basicDrinks.put(1, new Drink("чай", "чёрный", "вкусный чай", 50, "0.2"));
        basicDrinks.put(2, new Drink("чай", "зелёный", "вкусный чай", 55, "0.2"));
        basicDrinks.put(3, new Drink("чай", "чёрный", "чай-чай", 45, "0.2"));

        basicDrinks.put(4, new Drink("кофе", "чёрный", "БразилияРулит", 70, "0.2"));
        basicDrinks.put(5, new Drink("кофе", "черный с молоком", "сыпучая-отрава", 65, "0.2"));

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

    public ArrayList<String> getDrinkSize(){
        return drinkSize;
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
        basicDrinks.put(basicDrinks.size() + 1, d);
    }

    public HashMap<Integer, Component> getComponents() {
        return components;
    }

    public void addComponent(Component c) {
        components.put(components.size() + 1, c);
    }
}
