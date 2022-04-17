package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Drink> items = new ArrayList<Drink>();

    /*возвращает полную стоимость заказа*/
    public float getTotalCoast(){
        float result = 0;
        for(Drink d: items){
            result+= d.calculateCoast();
        }
        return result;
    }
}
