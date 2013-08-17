/* @author chad */
package knockknockserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Responder implements Runnable{
    ServerLogger logger;
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    
    Responder(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
        this.logger = new ServerLogger("Responder Logger");
    }
    
    private byte[] makeResponse() {
        String mes = "hello";
        return mes.getBytes();
    }

    @Override
    public void run() {
        byte[] dataForResponPacket = makeResponse();
        DatagramPacket respsonsePacket = new DatagramPacket(dataForResponPacket, dataForResponPacket.length, packet.getAddress(), packet.getPort());
        try {
            socket.send(packet);
        } catch (IOException ex) {
            logger.log("could not send response");
        }
    }

}
