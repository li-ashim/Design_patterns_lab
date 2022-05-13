package TeaCoffeeMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

class ClientHandler extends Thread {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    final ReentrantLock stdOutLock = new ReentrantLock();
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String clientOrder;
        String response = "Оплата прошла успешно!\n\n\n";
        try {
            // receive the order from client
            clientOrder = dis.readUTF();
            dos.writeUTF(response);

            Date date = new Date();
            stdOutLock.lock();
            System.out.println(clientOrder);
            System.out.println(dateFormat.format(date) + "\n\n");
            stdOutLock.unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
