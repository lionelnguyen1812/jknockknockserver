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
    public void testCreateUseAccount() throws Exception {
        System.out.println("createUseAccount");
        String user_name = "hungncsc";
        String encriptedPassword = "asdfawefgawiolmnsdfvjkhsd";
        String name_first = "nguyen";
        String name_last = "cong hung";
        String gender = "M";
        String email = "hungnc_bxxxxx@fpt.aptech.ac.vn";
        AccountManager instance = new AccountManager();
        int expResult = 7;
        int result = instance.createUseAccount(user_name, encriptedPassword, name_first, name_last, gender, email);
        assertEquals(expResult, result);
    }
}