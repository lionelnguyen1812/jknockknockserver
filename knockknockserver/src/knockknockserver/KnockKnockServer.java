/* @author chad */
package knockknockserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnockKnockServer {

    private static final int LOCAL_PORT = 8888;
    
    private DatagramSocket socket = null;
    private BufferedReader in = null;
    
    ServerLogger logger;

    public KnockKnockServer() {
        logger = new ServerLogger();
    }
    
    public void startListen() {
        new Thread() {
            @Override
            public void run() {
                try {
                    socket = new DatagramSocket(LOCAL_PORT);
                    logger.log("server started");
                    while (true) {
                        try {
                            byte[] buf = new byte[1024];
                            DatagramPacket packet = new DatagramPacket(buf, buf.length);
                            logger.log("server start to listen");
                            socket.receive(packet);
                            logger.log("packet received");
                            String clientIP = packet.getAddress().getHostAddress();
                            String quote = new String(packet.getData(), 0, packet.getLength());

                            System.out.println(quote);
                        } catch (IOException ex) {
                            Logger.getLogger(QuoteServerThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SocketException ex) {
                    Logger.getLogger(KnockKnockServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        KnockKnockServer server = new KnockKnockServer();
        server.startListen();
    }
}