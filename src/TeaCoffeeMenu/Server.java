package TeaCoffeeMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        Menu menu = Menu.getInstance();

        ServerSocket ss;
        // server is listening on port 8888
        try {
            ss = new ServerSocket(8888);
            System.out.println("Server is up and running!\n");
        } catch (IOException u) {
            System.out.println(u);
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        Socket s = null;
        while (true) {
            try {
                // socket object to receive incoming client requests
                s = ss.accept();

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                Thread t = new ClientHandler(s, dis, dos);
                executor.execute(t);

            } catch (Exception e) {
                try {
                    s.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }
}
