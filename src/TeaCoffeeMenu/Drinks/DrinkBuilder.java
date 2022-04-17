package TeaCoffeeMenu.Drinks;

import TeaCoffeeMenu.Components.Sugar;
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

    public void addSugar() {
        result.addComponent(Sugar.getInstance());
    }

    public void removeSugar() {
        result.removeComponent(Sugar.getInstance());
    }

    public void reset() {
        result = null;
    }

    public Drink getResult() {
        return result;
    }
}