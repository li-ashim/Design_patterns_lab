package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static Menu instance;
    private List<Drink> basicDrinks = new ArrayList<Drink>();
    private List<Component> components = new ArrayList<Component>();

    public Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }

    public void addDrink(Drink d){
        basicDrinks.add(d);
    }

    public void addComponent(Component c){
        components.add(c);
    }

    /*Вывести меню: все напитки, компоненты и их цены*/
    public void show(){
        System.out.println("Drinks: ");
        for( Drink d : basicDrinks){
            System.out.println(d);
        }
        System.out.println("Components: ");
        for( Component c : components){
            System.out.println(c);
        }

    }


}
