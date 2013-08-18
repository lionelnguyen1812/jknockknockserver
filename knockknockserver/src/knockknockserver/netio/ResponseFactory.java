/* @author chad */
package knockknockserver.netio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import knockknockserver.ServerLogger;
import knockknockserver.bzn.DBConnector;

public class ResponseFactory implements Runnable {

    ServerLogger logger;
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    DBConnector dbconnector = null;

    public ResponseFactory(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
        this.logger = new ServerLogger("Responder Logger");
    }

    private byte[] makeResponse() {
        String response = "";
        String[] splitedDataPacket = new String(this.packet.getData()).split(";");
        switch (splitedDataPacket[0]) {
            case "login":
                break;
            default:
                break;
        }
        return response.getBytes();
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
