/* @author chad */
package knockknockserver;

import java.io.IOException;
import java.net.DatagramSocket;

public class KnockKnockServer {

    private static final int LOCAL_PORT = 8888;
    private SocketService ss;
    ServerLogger logger;

    public KnockKnockServer() {
        logger = new ServerLogger("KnockKnockServer");
        ss = new SocketService();
    }
    
    public void startSocketService() throws IOException{
        ss.serve(LOCAL_PORT);
    }
    
    public static void main(String[] args) throws IOException {
        KnockKnockServer server = new KnockKnockServer();
        server.startSocketService();
    }
}