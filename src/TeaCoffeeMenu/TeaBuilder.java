package TeaCoffeeMenu;

import java.util.ArrayList;

public class TeaBuilder implements  IDrinkBuilder{

    private Drink d;

    @Override
    public void reset() {
        //d.setComponents();
    }

    @Override
    public void initialize(Drink d) {
        this.d = d;
    }

    @Override
    public Drink getResult() {
        return d;
    }

    public void addSugar(){
        //d.setComponents();
        //d.getComponents().add(Sugar.getInstance());
    }
    public void removeSugar(){
        //d.getComponents().remove(d.getComponents().size()-1);
    }
}
