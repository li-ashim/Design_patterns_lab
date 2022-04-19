package TeaCoffeeMenu;

public class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("Danil");
        c1.addDrinkToOrder();
        System.out.println(c1);
        c1.getOrder();
        c1.makeOrder();
        c1.payBill();
    }
}
