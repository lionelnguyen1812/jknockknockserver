/* @author chad */
package knockknockserver;

import java.net.SocketException;

public class KnockKnockServer {
    // :) co gang len
    // mes 1
    public static void main(String[] args) {
        try {
            new QuoteServerThread().start();
        } catch (SocketException ex) {
            System.out.println("cannot start quote thread");
        }
    }

}