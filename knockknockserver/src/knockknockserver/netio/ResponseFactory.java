/* @author chad */
package knockknockserver.netio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import knockknockserver.ServerLogger;
import knockknockserver.bzn.AccountConnector;

public class ResponseFactory implements Runnable {

    ServerLogger logger;
    DatagramSocket socket = null;
    DatagramPacket packet = null;

    public ResponseFactory(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
        this.logger = new ServerLogger("Responder Logger");
    }

    public String responToLoginRequest(String user_name, String encryptedPassword){
        StringBuilder response = new StringBuilder();
        
        int user_id;
        user_id = new AccountConnector().login(user_name, encryptedPassword);
        if (user_id > 0){
            //do something
        }
        
        return response.toString();
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
        String tobeResponse = makeResponse();
        byte[] buf = tobeResponse.getBytes();
        DatagramPacket packetToResponse = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
        try {
            socket.send(packetToResponse);
        } catch (IOException ex) {
            logger.log("could not send response");
        }
    }
}
