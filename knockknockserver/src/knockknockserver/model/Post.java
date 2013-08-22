/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknockserver.model;

/**
 *
 * @author Van
 */
public class Post {
    private int post_ID;
    private int user_ID;
    private String text;
    private String link;
    private String type;
    private String timeStamp;

    public Post(int post_ID, int user_ID, String text, String link, String type, String timeStamp) {
        this.post_ID = post_ID;
        this.user_ID = user_ID;
        this.text = text;
        this.link = link;
        this.type = type;
        this.timeStamp = timeStamp;
    }

    public int getPost_ID() {
        return post_ID;
    }

    public void setPost_ID(int post_ID) {
        this.post_ID = post_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    
}
