package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {

    private BronzeBankAccount account;
    private CoreBankAccount coreAccount;

    @BeforeEach
    void init(){
        this.coreAccount= new CoreBankAccount();
        this.account = new BronzeBankAccount(coreAccount);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
        this.account.withdraw(100);
        assertEquals(699, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanBalance(){
        this.account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> this.account.withdraw(1000));
    }
 

}
