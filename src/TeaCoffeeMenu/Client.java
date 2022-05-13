package TeaCoffeeMenu;

import TeaCoffeeMenu.Customer.Customer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket s = null;
        while (true) {
            try {
                Customer customer = new Customer();
                Scanner scanner = new Scanner(System.in);
                int option;
                while (true) {
                    System.out.println("0: Оплатить заказ");
                    System.out.println("1: Добавить напиток");
                    option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                    customer.addDrinkToOrder();
                }

                String bill = customer.payBill();

                // establish the connection with server port 8888
                s = new Socket("localhost", 8888);
                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println(bill);
                dos.writeUTF(bill);

                String response = dis.readUTF();
                System.out.println(response);

                // closing resources
                dis.close();
                dos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
