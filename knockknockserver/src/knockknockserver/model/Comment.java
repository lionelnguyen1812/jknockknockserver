/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknockserver.model;

/**
 *
 * @author Van
 */
public class Comment {
    private int cmt_ID;
    private int user_ID;
    private int post_ID;
    private String content;

    public Comment(int cmt_ID, int user_ID, int post_ID, String content) {
        this.cmt_ID = cmt_ID;
        this.user_ID = user_ID;
        this.post_ID = post_ID;
        this.content = content;
    }

    public int getCmt_ID() {
        return cmt_ID;
    }

    public void setCmt_ID(int cmt_ID) {
        this.cmt_ID = cmt_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getPost_ID() {
        return post_ID;
    }

    public void setPost_ID(int post_ID) {
        this.post_ID = post_ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
