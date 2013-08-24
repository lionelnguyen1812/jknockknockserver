/* @author chad */
package knockknockserver.bzn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {


    public static Connection getConnection() throws Exception {
       
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://VANANH\\VANANH:1444;databaseName=chicklingslove", "sa", "va123456");
//=======
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection("jdbc:sqlserver://localhost:4444;databaseName=chicklingslove", "sa", "Mainguyen");
//>>>>>>> 6d1d5fdc347010f290d734f79308d0b38cdf5095

    }
}
