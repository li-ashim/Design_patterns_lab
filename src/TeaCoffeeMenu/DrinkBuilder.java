package TeaCoffeeMenu;

import java.util.HashMap;
import java.util.Scanner;

public class DrinkBuilder implements IBuilder<Drink> {

    private static DrinkBuilder instance;
    private Drink result;
    private HashMap<Integer, Component> suitedComponents;

    Scanner scanner = new Scanner(System.in);


    private DrinkBuilder() {}
    public static DrinkBuilder getInstance() {
        if (instance == null) {
            instance = new DrinkBuilder();
        }
        return instance;
    }

    @Override
    public void reset() {
        result = null;
    }

    @Override
    public void initialize(Drink d) {
        result = d.copy();
        suitedComponents = Menu.getInstance().getSuitedComponents(result.getType());
        System.out.println("Выберите размер напитка");
        for(String s : Menu.getInstance().getDrinkSize()){
            System.out.println(Menu.getInstance().getDrinkSize().indexOf(s)+1+": "+s);
        }
        result.setSize(Menu.getInstance().getDrinkSize().get(scanner.nextInt()-1));
    }

    @Override
    public void addComponent() {
        for(int i : suitedComponents.keySet()){
            System.out.println("Сколько "+suitedComponents.get(i)+" добавить?");
            /*Ввод значения*/
            int n = scanner.nextInt();
            for(int j = 0; j<n; j++){
                result.addComponent(suitedComponents.get(i));
            }
        }

    }

    @Override
    public Drink getResult() {
        return result;
    }
}
