/* @author chad */
package knockknockserver.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Session {
    int user_id;
    String ident;

    public Session(int user_id) {
        this.user_id = user_id;
        initIdentCode();
    }

    private void initIdentCode() {
        try {
            Random rd = new Random();
            rd.setSeed(System.currentTimeMillis());
            String tobeHash = String.valueOf(user_id) + String.valueOf(rd.nextInt());
            byte[] bytes = tobeHash.getBytes();
            MessageDigest m = MessageDigest.getInstance("SHA1");
            byte[] digest = m.digest(bytes);
            String result = new BigInteger(1, digest).toString(16);
            this.ident = result;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getUser_id() {
        return user_id;
    }

    public String getIdent() {
        return ident;
    }
    
}
