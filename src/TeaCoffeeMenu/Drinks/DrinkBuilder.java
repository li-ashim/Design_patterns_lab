package TeaCoffeeMenu.Drinks;

public interface DrinkBuilder {
    public void initialize(int drinkId);
    public void reset();
    public Drink getResult();
}