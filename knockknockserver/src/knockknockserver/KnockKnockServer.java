/* @author chad */
package knockknockserver;

import java.net.DatagramSocket;

public class KnockKnockServer {

    private static final int LOCAL_PORT = 8888;
    
    ServerLogger logger;

    public KnockKnockServer() {
        logger = new ServerLogger("KnockKnockServer");
    }
    
    
    public static void main(String[] args) {
        KnockKnockServer server = new KnockKnockServer();
    }
}