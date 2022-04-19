package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Drink> items = new ArrayList<Drink>();
    private float result;

    /*возвращает полную стоимость заказа*/
    public float getTotalCoast(){
        for(Drink d: items){
            result+= d.calculateCoast();
        }
        return result;
    }

    public void addDrink(Drink d){
        items.add(d);
    }

    @Override
    public String toString() {
        result = getTotalCoast();
        return "Order{" +
                "items=" + items +
                ", result=" + result +
                '}';
    }
}
