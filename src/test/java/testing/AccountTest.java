package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void myTest(){
        Account account = new Account();
        assertFalse(account.isActive(), "Check if new account is not active");
    }

    @Test
    void myTest2(){
        Account account = new Account();
        assertFalse(account.isActive());
        account.activate();
        assertTrue(account.isActive());
    }
}
