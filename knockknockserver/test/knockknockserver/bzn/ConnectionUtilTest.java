package knockknockserver.bzn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chad
 */
public class ConnectionUtilTest {
    
    public ConnectionUtilTest() {
    }

    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        String result = "";
        try {
            Connection cnn = ConnectionUtil.getConnection();
            result = cnn.getCatalog();
        } catch (Exception ex) {
            Logger.getLogger(ConnectionUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("chicklingslove", result);
    }
}