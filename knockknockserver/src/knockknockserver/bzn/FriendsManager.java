/* @author chad */
package knockknockserver.bzn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import knockknockserver.model.Friend;

public class FriendsManager {
    
    public List<Friend> getAllFriends(int user_id) throws ClassNotFoundException, SQLException{
        List<Friend> friendslist = new ArrayList<>();
        
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call get_all_friends(?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        ResultSet rs = cstm.executeQuery();
        while(rs.next()){
            Friend f = new Friend();
            f.setFriend_id(rs.getInt("friend_id"));
            f.setUser_Name(rs.getString("user_name"));
            f.setFirst_name(rs.getString("name_first"));
            f.setLast_name(rs.getString("name_last"));
            f.setGender(rs.getString("gender").charAt(0));
            f.setEmail(rs.getString("email"));
            f.setAvatar(rs.getString("avatar"));
            f.setOnline(rs.getBoolean("online"));
            f.setAccepted(rs.getBoolean("accepted"));
            
            friendslist.add(f);
        }
        
        return friendslist;
    }
    
    public boolean requestFriend(int user_id, int friend_id) throws SQLException, ClassNotFoundException{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call add_friend(?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        cstm.setInt(2, friend_id);
        return cstm.executeUpdate() > 0;
    }
    
    public boolean unfriend(int user_id, int friend_id) throws ClassNotFoundException, SQLException{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call unfriend(?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        cstm.setInt(2, friend_id);
        return cstm.executeUpdate() > 0;
    }
    
    public boolean acceptFriendRequest(int user_id, int request_from_id) throws ClassNotFoundException, SQLException{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call accept_friendship_request(?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        cstm.setInt(2, request_from_id);
        return cstm.executeUpdate() > 0;
    }
    
    public boolean removeFriendRequest(int user_id, int request_from_id) throws ClassNotFoundException, SQLException{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call remove_friendship_request(?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        cstm.setInt(2, request_from_id);
        return cstm.executeUpdate() > 0;
    }
}
