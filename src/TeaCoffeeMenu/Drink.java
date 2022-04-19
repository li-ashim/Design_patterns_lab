package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String type;
    private String name;
    private String manufacture;
    private String size;
    private float bscPrice;
    private List<Component> components = new ArrayList<Component>();

    public Drink(String type, String name, String manufacture, float bscPrice, String size) {
        this.type = type;
        this.name = name;
        this.manufacture = manufacture;
        this.bscPrice = bscPrice;
        this.size = size;
    }

    /*Подсчет итоговой стоимости напитка*/
    public float calculateCoast(){
        float resultCoast = 0;

        for(Component comp : components){
            resultCoast+=comp.getPrice();
        }
        return resultCoast+bscPrice;
    }


    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", size='" + size + '\'' +
                ", bscPrice=" + bscPrice +
                ", components=" + components +
                '}';
    }

    public void setSize(String size){
        this.size = size;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public float getBscPrice() {
        return bscPrice;
    }

    public void setBscPrice(float bscPrice) {
        this.bscPrice = bscPrice;
    }

    public void addComponent(Component c){
        components.add(c);
    }

    public Drink copy() {
        return new Drink(this.type, this.name, this.manufacture, this.bscPrice, this.size);
    }
}
