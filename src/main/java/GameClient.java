import java.io.IOException;
import java.net.*;

public class GameClient extends Thread{
    public static GameClient socketClient;

    private InetAddress ipAdress;
    private DatagramSocket socket;
    private GameScene game;
    private int port;

    public GameClient(String name, String ipAdress, int port, GameScene game) throws Exception{
        this.game = game;
        this.port = port;
        try {
            this.socket = new DatagramSocket(port);
            this.ipAdress = InetAddress.getByName(ipAdress);
            this.setName(name);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e){
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
            System.out.println("Server > " + new String(packet.getData()));
        }
    }

    public void sendData(byte[] data){
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAdress, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
