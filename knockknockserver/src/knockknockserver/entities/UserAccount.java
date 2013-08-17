/* @author chad */
package knockknockserver.entities;

import java.awt.Image;
import java.sql.Date;

public class UserAccount {
    private String user_ID;
    private String user_Name;
    private String password;
    private String first_Name;
    private String last_Name;
    private char gender;
    private String email;
    private Image avatar;
    private boolean active;
    private boolean online;
    private Date timestamp;

    public UserAccount(String user_ID, String user_Name, String password, String first_Name, String last_Name, char gender, String email, Image avatar, boolean active, boolean online, Date timestamp) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.password = password;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.gender = gender;
        this.email = email;
        this.avatar = avatar;
        this.active = active;
        this.online = online;
        this.timestamp = timestamp;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String last_Name) {
        this.last_Name = last_Name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    
    

}
