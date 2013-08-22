package knockknockserver.bzn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostManager {

    public int createPost(int userID, String text, String link, String type, String timeStamp) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "{call add_post(?,?,?,?,?)}";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setString(2, text);
            cstm.setString(3, link);
            cstm.setString(4, type);
            cstm.setString(5, timeStamp);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int createComment(int userID, int postID, String content) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "call add_comment(?,?,?)";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, postID);
            cstm.setString(3, content);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int removeComment(int cmtID) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "call remove_comment(?)";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, cmtID);
            int row = cstm.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    //phan anh lam tu day tro xuong
    public boolean likePost(int userID, int postID) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "{call do_like_post(?, ?)}";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, postID);
            return cstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean likeComment(int userID, int cmtID) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "{call do_like_comment(?, ?)}";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, cmtID);
            return cstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean unlikePost(int userID, int postID){
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "{call do_unlike_post(?, ?)}";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, postID);
            return cstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean unlikeComment(int userID, int cmtID){
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "{call do_unlike_comment(?, ?)}";
            CallableStatement cstm = conn.prepareCall(sql);
            cstm.setInt(1, userID);
            cstm.setInt(2, cmtID);
            return cstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
