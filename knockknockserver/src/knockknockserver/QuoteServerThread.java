/* @author chad */
package knockknockserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

//va joined

public class QuoteServerThread extends Thread{
    private static final int LOCAL_PORT = 8888;;
    
    private DatagramSocket socket = null;
    private BufferedReader in = null;

    public QuoteServerThread() throws SocketException {
        this("QuoteServerThread");
    }

    public QuoteServerThread(String name) throws SocketException {
        super(name);
        
        socket = new DatagramSocket(LOCAL_PORT);
    }

    @Override
    public void run() {
        while (true){
            try {
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String clientIP = packet.getAddress().getHostAddress();
                String quote = new String(packet.getData(), 0, packet.getLength());
                
                System.out.println(quote);
            } catch (IOException ex) {
                Logger.getLogger(QuoteServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
