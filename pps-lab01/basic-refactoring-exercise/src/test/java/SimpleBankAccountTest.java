import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private double NegativeAmount=-50;
    private double Amount=100;
    private double WithdrawAmount=70;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), Amount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), Amount);
        bankAccount.deposit(2, Amount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), Amount);
        bankAccount.withdraw(accountHolder.getId(), WithdrawAmount);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), Amount);
        bankAccount.withdraw(2, WithdrawAmount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testGetBalance(){
        bankAccount.deposit(this.accountHolder.getId(),Amount);
        assertEquals(100,this.bankAccount.getBalance());
    }

    @Test
    void testGetBalanceAfterWithdrawWithFee(){
        this.bankAccount.deposit(this.accountHolder.getId(),Amount);
        this.bankAccount.withdrawWithFee(this.accountHolder.getId(),WithdrawAmount);
        assertEquals(29,this.bankAccount.getBalance());
    }

    @Test
    void testWithdrawAnHigherAmountThanTheBalance(){
        this.bankAccount.deposit(this.accountHolder.getId(),Amount);
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.withdrawWithFee(this.accountHolder.getId(),Amount));
    }

    @Test
    void testDepositWithNegativeAmount()
    {
        assertThrows(IllegalArgumentException.class,() -> this.bankAccount.deposit(this.accountHolder.getId(),NegativeAmount));
    }

}
