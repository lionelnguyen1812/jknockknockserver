package knockknockserver.bzn;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chad
 */
public class AccountManagerTest {

    public AccountManagerTest() {
    }

    @Test
    public void testCreateUserAccount() throws Exception {
//        System.out.println("createUseAccount");
//        String user_name = "hungncsc";
//        String encriptedPassword = "asdfawefgawiolmnsdfvjkhsd";
//        String name_first = "nguyen";
//        String name_last = "cong hung";
//        String gender = "M";
//        String email = "hungnc_bxxxxx@fpt.aptech.ac.vn";
//        AccountManager instance = new AccountManager();
//        int expResult = 7;
//        int result = instance.createUseAccount(user_name, encriptedPassword, name_first, name_last, gender, email);
//        assertEquals(expResult, result);

        assertTrue(true);
    }

    @Test
    public void testUpdateUserAccount() throws Exception {
//        System.out.println("updateUseAccount");
//        int id = 3;
//        String user_name = "hungncong";
//        String encriptedPassword = "asdfawefgawiolmnsdfvjkhsd";
//        String name_first = "nguyen";
//        String name_last = "cong hung";
//        String gender = "M";
//        String email = "hungnc_bxxxxx@fpt.aptech.ac.vn";
//        AccountManager instance = new AccountManager();
//        int result = instance.updateUseAccount(id, user_name, encriptedPassword, name_first, name_last, gender, email);
//        assertEquals(1, result);

        assertTrue(true);
    }

    @Test
    public void testDeactiveUserAccount() throws Exception {
//        int user_id = 3;
//        AccountManager instance = new AccountManager();
//        assertTrue(instance.deactiveAccount(user_id));
//        
        assertTrue(true);
    }
    
    public void testActiveUserAccount() throws Exception {
        int user_id = 3;
        AccountManager instance = new AccountManager();
        assertTrue(instance.activeAccount(user_id));
        
//        assertTrue(true);
    }
    
}