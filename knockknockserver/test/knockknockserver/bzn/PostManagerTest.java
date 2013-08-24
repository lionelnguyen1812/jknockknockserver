/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknockserver.bzn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Van
 */
public class PostManagerTest {
   
    /**
     * Test of createPost method, of class PostManager.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        int userID = 0;
        String text = "chan chan";
        String link = "aaaa";
        String type = "text";
        PostManager instance = new PostManager();
        int expResult = 1;
        int result = instance.createPost(userID, text, link, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of removePost method, of class PostManager.
//     */
//    @Test
//    public void testRemovePost() {
//        System.out.println("removePost");
//        int postID = 0;
//        PostManager instance = new PostManager();
//        int expResult = 0;
//        int result = instance.removePost(postID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createComment method, of class PostManager.
//     */
//    @Test
//    public void testCreateComment() {
//        System.out.println("createComment");
//        int userID = 0;
//        int postID = 0;
//        String content = "";
//        PostManager instance = new PostManager();
//        int expResult = 0;
//        int result = instance.createComment(userID, postID, content);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeComment method, of class PostManager.
//     */
//    @Test
//    public void testRemoveComment() {
//        System.out.println("removeComment");
//        int cmtID = 0;
//        PostManager instance = new PostManager();
//        int expResult = 0;
//        int result = instance.removeComment(cmtID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}