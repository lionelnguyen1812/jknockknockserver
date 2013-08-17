package knockknockserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chad
 */
public class SocketServiceTest {

    @Test
    public void testReceiveOnePacket() throws IOException {
        SocketService ss = new SocketService();
        ss.serve(8888);

        //wait for delay of "serve" thread
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        sendMes();

        //wait for send threads
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        ss.close();
        assertEquals(1, ss.connections());
    }

    private void sendMes() {
        try {
            String mes = "abc";
            byte[] buf = mes.getBytes();
            Random random = new Random(new Date().getTime());
            DatagramSocket socket = new DatagramSocket(random.nextInt(60000) + 10000);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
            socket.send(packet);
            socket.close();
        } catch (IOException ex) {
        }
    }
}