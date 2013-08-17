/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialNetwork.Account.ConnectDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
 

/**
 *
 * @author caubuonviai1803
 */
public class ConnectDataBase {

    public Connection connectionDataBase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=chicklingslove", "sa", "123456");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
