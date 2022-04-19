package TeaCoffeeMenu.Drinks;

import TeaCoffeeMenu.Menu;

public class DrinkBuilder {
    private Drink result;
    private static DrinkBuilder instance;

    private DrinkBuilder() {}
    public static DrinkBuilder getInstance() {
        if (instance == null) {
            instance = new DrinkBuilder();
        }
        return instance;
    }

    public void initialize(int drinkId) {
        result = Menu.getInstance().getBasicDrinks().get(drinkId).copy();
    }

    public void addComponent(int componentId) {
        result.addComponent(Menu.getInstance().getComponents().get(componentId));  // Проверка соответствия айди делается в вызывающем коде.
    }

    public void removeComponent(int componentId) {
        result.removeComponent(Menu.getInstance().getComponents().get(componentId));
    }

    public void reset() {
        result = null;
    }

    public Drink getResult() {
        return result;
    }
}