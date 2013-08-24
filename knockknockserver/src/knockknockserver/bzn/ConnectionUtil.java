/* @author chad */
package knockknockserver.bzn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://VANANH\\VANANH:1444;databaseName=chicklingslove", "sa", "va123456");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
