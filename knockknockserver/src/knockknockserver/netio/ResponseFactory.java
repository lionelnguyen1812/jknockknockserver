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

    public String responToLoginRequest(String userID, String encryptedPassword){
        String response = "";
        
        
        return response;
    }
    
    private String makeResponse() {
        String response = "";
        String[] splitedDataPacket = new String(this.packet.getData()).split(";");
        switch (splitedDataPacket[0]) {
            case "login":
                String userID = splitedDataPacket[1];
                String encryptedPassword = splitedDataPacket[2];
                response = responToLoginRequest(userID, encryptedPassword);
                break;
            default:
                break;
        }
        return response;
    }

    @Override
    public void run() {
        String dataForResponPacket = makeResponse();
        byte[] buf = dataForResponPacket.getBytes();
        DatagramPacket respsonsePacket = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
        try {
            socket.send(respsonsePacket);
        } catch (IOException ex) {
            logger.log("could not send response");
        }
    }
}
