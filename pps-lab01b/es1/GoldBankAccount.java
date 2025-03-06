package e1;

public class GoldBankAccount implements BankAccount {

    private final CoreBankAccount base;
    private final static int OVERDRAFT=500;
    public GoldBankAccount(CoreBankAccount coreAccount)
    {
        base= coreAccount;
    }
    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if((base.getBalance()-amount)<(-OVERDRAFT)){
            throw new IllegalArgumentException("Can't have negative balance up to OVERDRAFT");
        }
        base.withdraw(amount);
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }
}
