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
            String email) throws SQLException {
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
        return id;
    }

    public int updateUseAccount(
            int id,
            String user_name,
            String encriptedPassword,
            String name_first,
            String name_last,
            String gender,
            String email) throws SQLException {
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
        return row;
    }
}
