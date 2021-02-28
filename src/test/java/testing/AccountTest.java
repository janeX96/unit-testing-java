package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void newAccountShouldBeNotActiveAfterCreation(){
        //given
        Account account = new Account();

        //then
        assertFalse(account.isActive(), "Check if new account is not active");
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account account = new Account();

        //when
        account.activate();

        //then
        assertTrue(account.isActive());
    }
}
