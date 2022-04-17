package TeaCoffeeMenu;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String type;
    private String name;
    private String manufacture;
    private float bscPrice;
    private List<Component> components = new ArrayList<Component>();

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
                ", bscPrice=" + bscPrice +
                '}';
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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
