/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialNetwork.Account.Model;

/**
 *
 * @author caubuonviai1803
 */
public class Account {

    private int user_id;
    private String user_name;
    private String password;
    private String name_first;
    private String name_last;
    private String email;
    private String avatar;
    private int active;
    private int online;
    private double time_stamp;

    public Account(int user_id, String user_name, String password, String name_first, String name_last, String email, String avatar, int active, int online, double time_stamp) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.name_first = name_first;
        this.name_last = name_last;
        this.email = email;
        this.avatar = avatar;
        this.active = active;
        this.online = online;
        this.time_stamp = time_stamp;
    }

    public Account(String user_name, String password, String name_first, String name_last, String email, String avatar, int active, int online, double time_stamp) {
        this.user_name = user_name;
        this.password = password;
        this.name_first = name_first;
        this.name_last = name_last;
        this.email = email;
        this.avatar = avatar;
        this.active = active;
        this.online = online;
        this.time_stamp = time_stamp;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_first() {
        return name_first;
    }

    public void setName_first(String name_first) {
        this.name_first = name_first;
    }

    public String getName_last() {
        return name_last;
    }

    public void setName_last(String name_last) {
        this.name_last = name_last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public double getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(double time_stamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString() {
        return "Account{" + "user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", name_first=" + name_first + ", name_last=" + name_last + ", email=" + email + ", avatar=" + avatar + ", active=" + active + ", online=" + online + ", time_stamp=" + time_stamp + '}';
    }
    
}
