package knockknockserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chad
 */
public class KnockKnockServerTest {
    
    public KnockKnockServerTest() {
    }

    @Test
    public void testSQLConnection() throws Exception{
        SocketService ss = new SocketService();
        ss.serve(8888);
        sendPacket(8888);
        assertEquals(1, ss.connections());
    }

    private void sendPacket(int port) {
        try {
            byte[] buf = "abc".getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
            DatagramSocket socket = new DatagramSocket(8886);
            socket.send(packet);
        }  catch (IOException ex) {
            System.out.println("could not connect");
        }
    }
}