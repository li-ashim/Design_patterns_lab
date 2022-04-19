package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    private static Menu instance;
    private static DatabaseDummy db;
    private Menu(){};
    public static Menu getInstance(){
        if(instance == null){
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

    public  ArrayList<String> getDrinkSize(){
        return db.getDrinkSize();
    }

    public void addDrink(Drink d) {
        db.addBasicDrink(d);
    }

    public void addComponent(Component c) {
        db.addComponent(c);
    }


    /*Вывести меню: все напитки, компоненты и их цены*/
    public void show(){
        System.out.println("Drinks: ");
        System.out.println(db.getBasicDrinks());
        System.out.println("Components: ");
        System.out.println(db.getComponents());

    }


}

