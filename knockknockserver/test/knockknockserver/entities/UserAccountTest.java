package knockknockserver.entities;

import knockknockserver.model.UserAccount;
import java.awt.Image;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chad
 */
public class UserAccountTest {
    
    public UserAccountTest() {
    }

    @Test
    public void testGetUser_ID() {
        System.out.println("getUser_ID");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getUser_ID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUser_ID() {
        System.out.println("setUser_ID");
        String user_ID = "";
        UserAccount instance = null;
        instance.setUser_ID(user_ID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUser_Name() {
        System.out.println("getUser_Name");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getUser_Name();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUser_Name() {
        System.out.println("setUser_Name");
        String user_Name = "";
        UserAccount instance = null;
        instance.setUser_Name(user_Name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserAccount instance = null;
        instance.setPassword(password);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String first_Name = "";
        UserAccount instance = null;
        instance.setFirstName(first_Name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String last_Name = "";
        UserAccount instance = null;
        instance.setLastName(last_Name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetGender() {
        System.out.println("getGender");
        UserAccount instance = null;
        char expResult = ' ';
        char result = instance.getGender();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetGender() {
        System.out.println("setGender");
        char gender = ' ';
        UserAccount instance = null;
        instance.setGender(gender);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserAccount instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserAccount instance = null;
        instance.setEmail(email);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAvatar() {
        System.out.println("getAvatar");
        UserAccount instance = null;
        Image expResult = null;
        Image result = instance.getAvatar();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAvatar() {
        System.out.println("setAvatar");
        Image avatar = null;
        UserAccount instance = null;
        instance.setAvatar(avatar);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsActive() {
        System.out.println("isActive");
        UserAccount instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        UserAccount instance = null;
        instance.setActive(active);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsOnline() {
        System.out.println("isOnline");
        UserAccount instance = null;
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOnline() {
        System.out.println("setOnline");
        boolean online = false;
        UserAccount instance = null;
        instance.setOnline(online);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        UserAccount instance = null;
        Date expResult = null;
        Date result = instance.getTimestamp();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetTimestamp() {
        System.out.println("setTimestamp");
        Date timestamp = null;
        UserAccount instance = null;
        instance.setTimestamp(timestamp);
        fail("The test case is a prototype.");
    }
}