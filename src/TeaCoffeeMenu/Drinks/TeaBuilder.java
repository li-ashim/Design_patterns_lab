package TeaCoffeeMenu.Drinks;

import TeaCoffeeMenu.Menu;
import TeaCoffeeMenu.Components.Sugar;

public class TeaBuilder implements DrinkBuilder{
    private Drink result;

    @Override
    public void initialize(int drinkId) {
        result = Menu.getInstance().getBasicDrinks().get(drinkId).copy();
    }

    public void addSugar() {
        result.addComponent(Sugar.getInstance());
    }

    public void removeSugar() {
        result.removeComponent(Sugar.getInstance());
    }

    @Override
    public void reset() {
        result = null;
    }

    @Override
    public Drink getResult() {
        return result;
    }
}
