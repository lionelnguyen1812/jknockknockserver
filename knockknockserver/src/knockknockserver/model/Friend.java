/* @author chad */
package knockknockserver.model;

import java.awt.Image;

public class Friend {
    private int friend_id;
    private String user_Name;
    private String first_name;
    private String last_name;
    private char gender;
    private String email;
    private String avatar;
    private boolean online;
    private boolean accepted;

    public Friend() {
    }

    public Friend(int friend_id, String user_Name, String first_name, String last_name, char gender, String email, String avatar, boolean online, boolean accepted) {
        this.friend_id = friend_id;
        this.user_Name = user_Name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.avatar = avatar;
        this.online = online;
        this.accepted = accepted;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
}
