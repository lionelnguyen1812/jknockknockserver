/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialNetwork.Account.Controler;

import SocialNetwork.Account.Model.Account;
import SocialNetwork.Account.Model.AccountManagement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caubuonviai1803
 */
public class AccountControler {

    AccountManagement am = new AccountManagement();

    public List<Account> getListAcc() {
        return am.getListAcc();
    }

    public boolean addAcc(Account acc) {
        return am.addAcc(acc);
    }

    public List<Account> searchAccount(String name) {
        return am.searchAcc(name);
    }

    public Account searchId(int id) {
        return am.search_Id(id);
    }

    public boolean deleteAcc(int id) {
        return am.deleteAcc(id);
    }

    public boolean updateAcc(int id, Account acc) {
        return am.updateAcc(id, acc);
    }

    public String CiphertextMD5(String passWord) {
        return am.CiphertextMD5(passWord);
    }

    public boolean loginAccount(String user_name, String password) {
        try {
            return am.login(user_name, password);
        } catch (Exception ex) {
            System.out.println(ex);
         }
        return false;
    }
}
