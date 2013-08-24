/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknockserver.bzn;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMStateSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Van
 */
public class PostManager {

    public int createPost(int userID, String text, String link, String type) throws SQLException {
        int postID = -1;

        Connection conn = ConnectionUtil.getConnection();
        String sql = "{call add_post(?,?,?,?,?)}";
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.registerOutParameter(1, java.sql.Types.INTEGER);
        cstm.setInt(2, userID);
        cstm.setString(3, text);
        cstm.setString(4, link);
        cstm.setString(5, type);
        cstm.execute();
        postID = cstm.getInt(1);
        return postID;

    }

    public int removePost(int postID) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "call  remove_post(?)";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, postID);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int createComment(int userID, int postID, String content) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "call add_comment(?,?,?)";
        try {
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, postID);
            cstm.setString(3, content);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int removeComment(int cmtID) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "call remove_comment(?)";
        try {
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, cmtID);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
