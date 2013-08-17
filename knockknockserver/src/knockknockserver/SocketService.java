/* @author chad */
package knockknockserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

class SocketService {

    private Thread serveThread = null;
    ServerLogger logger;
    DatagramSocket socket = null;
    private int connections = 0;

    public SocketService() {
        this.logger = new ServerLogger("SocketService");
    }

    void serve(int port) throws IOException {
        socket = new DatagramSocket(port);
        serveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    listenToNextPacket();
                }
            }
        });
        serveThread.start();
    }

    private void listenToNextPacket() {
        try {
            byte[] buf = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            logger.log("waiting for new packet");
            socket.receive(packet);
            logger.log("received a packet");
            new Thread(new Responder(socket, packet)).start();
            connections++;
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        socket.close();
    }

    public int connections() {
        return connections;
    }
}
