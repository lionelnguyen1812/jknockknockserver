/* @author chad */
package knockknockserver;

import knockknockserver.netio.SocketService;
import java.io.IOException;
import knockknockserver.bzn.SessionsManager;
public class KnockKnockServer {

    private static final int LOCAL_PORT = 8888;
    private SocketService ss;
    ServerLogger logger;
    SessionsManager sessionsManager;

    public KnockKnockServer() {
        logger = new ServerLogger("KnockKnockServer");
        ss = new SocketService();
        sessionsManager = new SessionsManager();
    }
    
    public void startSocketService() throws IOException{
        ss.serve(LOCAL_PORT);
    }
    
    public static void main(String[] args) throws IOException {
        KnockKnockServer server = new KnockKnockServer();
        server.startSocketService();
    }
}