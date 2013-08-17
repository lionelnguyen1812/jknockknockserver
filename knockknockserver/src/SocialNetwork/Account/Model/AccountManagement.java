/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialNetwork.Account.Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import SocialNetwork.Account.ConnectDataBase.ConnectDataBase;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author caubuonviai1803
 */
public class AccountManagement {

    List<Account> listAcc = new ArrayList<>();
    ConnectDataBase connectDataBase = new ConnectDataBase();

    public List<Account> getListAcc() {
        return listAcc;
    }

    public boolean addAcc(Account acc) {
        if (listAcc.add(acc)) {
            return true;
        }
        return false;
    }

    public List<Account> searchAcc(String name) {
        List<Account> list = new ArrayList<>();
        for (Account acc : listAcc) {
            if (acc.getName_first().contains(name)) {
                list.add(acc);
            }
        }
        return list;
    }

    public Account search_Id(int user_id) {
        for (Account account : listAcc) {
            if (account.getUser_id() == user_id) {
                return account;
            }
        }
        return null;
    }

    public boolean deleteAcc(int user_id) {
        Account acc = search_Id(user_id);
        listAcc.remove(acc);
        return true;
    }

    public boolean updateAcc(int user_id, Account acc) {
        Account account = search_Id(user_id);
        account.setUser_name(acc.getUser_name());
        account.setPassword(acc.getPassword());
        account.setName_first(acc.getName_first());
        account.setName_last(acc.getName_last());
        account.setEmail(acc.getEmail());
        account.setAvatar(acc.getAvatar());
        account.setActive(acc.getActive());
        account.setOnline(acc.getOnline());
        account.setTime_stamp(acc.getTime_stamp());
        return true;
    }

    public String CiphertextMD5(String pass) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] buf = pass.getBytes();
            byte[] output = messageDigest.digest(buf);
            String hex = DatatypeConverter.printHexBinary(output);
            return hex;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        return null;

    }

    public boolean login(String user_name, String password) throws Exception {
        Connection c = connectDataBase.connectionDataBase();
        CallableStatement cs = c.prepareCall("{call login(?,?)}");
        cs.setString(1, user_name);
        cs.setString(2, password);
        ResultSet rs = cs.executeQuery();
        String s = null;
        while (rs.next()) {
            s = rs.getString(1);
            System.out.println(s);
            return rs.equals("true") ? true : false;
        }
        c.close();
        cs.close();
        return false;
    }

    public static void main(String[] args) throws Exception {
        AccountManagement am = new AccountManagement();
        am.login("anhntv", "abcxyz");
    }
}
