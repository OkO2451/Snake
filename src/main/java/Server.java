import java.io.IOException;
import java.net.*;

public class Server extends Thread{

    private DatagramSocket socket;
    private GameScene game;


    public Server(String name,  GameScene game) throws Exception{
        this.game = game;

        try {
            this.socket = new DatagramSocket();

            this.setName(name);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = new String(packet.getData());
            if(message.trim().equalsIgnoreCase("ping")){

                sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
            }

        }
    }

    public void sendData(byte[] data, InetAddress ipAdress, int port){
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAdress, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}