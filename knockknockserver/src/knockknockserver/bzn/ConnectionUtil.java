/* @author chad */
package knockknockserver.bzn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:4444;databaseName=chicklingslove", "sa", "Mainguyen");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
