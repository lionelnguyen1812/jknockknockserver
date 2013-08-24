/* @author chad */
package knockknockserver.bzn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountManager {

    public int createUseAccount(
            String user_name,
            String encriptedPassword,
            String name_first,
            String name_last,
            String gender,
            String email) throws SQLException, Exception {
        int id = -1;
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call INSERT_USER_ACCOUNT(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setString(1, user_name);
        cstm.setString(2, encriptedPassword);
        cstm.setString(3, name_first);
        cstm.setString(4, name_last);
        cstm.setString(5, gender);
        cstm.setString(6, email);
        cstm.registerOutParameter(7, java.sql.Types.INTEGER);
        cstm.execute();
        id = cstm.getInt(7);
        cnn.close();
        return id;
    }

    public int updateUseAccount(
            int id,
            String user_name,
            String encriptedPassword,
            String name_first,
            String name_last,
            String gender,
            String email) throws SQLException, Exception {
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call UPDATE_USER_ACCOUNT(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, id);
        cstm.setString(2, user_name);
        cstm.setString(3, encriptedPassword);
        cstm.setString(4, name_first);
        cstm.setString(5, name_last);
        cstm.setString(6, gender);
        cstm.setString(7, email);
        int row = cstm.executeUpdate();
        cnn.close();
        return row;
    }
    
    public boolean deactiveAccount(int user_id) throws SQLException, Exception{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call deactive_account(?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        return cstm.executeUpdate() > 0;
    }
    
    public boolean activeAccount(int user_id) throws SQLException, Exception{
        Connection cnn = ConnectionUtil.getConnection();
        String sql = "{call active_account(?)}";
        CallableStatement cstm = cnn.prepareCall(sql);
        cstm.setInt(1, user_id);
        return cstm.executeUpdate() > 0;
    }
    
    
}
