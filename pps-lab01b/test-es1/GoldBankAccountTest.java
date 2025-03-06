package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {
    private GoldBankAccount account;
    private CoreBankAccount coreAccount;

    @BeforeEach
    void init(){
        this.coreAccount= new CoreBankAccount();
        this.account = new GoldBankAccount(coreAccount);
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
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverdraft(){
        this.account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> this.account.withdraw(1600));
    }
    @Test
    public void testCanWithdrawUpTo500(){
        this.account.deposit(1000);
        this.account.withdraw(1300);
        assertEquals(-300,account.getBalance());
        this.account.withdraw(200);
        assertEquals(-500,account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> this.account.withdraw(20));

    }
}
