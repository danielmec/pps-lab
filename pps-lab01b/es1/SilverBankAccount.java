package e1;

public class SilverBankAccount implements BankAccount{

    //Hardcoded dependency
    //private CoreBankAccount base = new CoreBankAccount();

    private final CoreBankAccount base;
    private static final int FEE = 1;

    //Dependency injection
    public SilverBankAccount(CoreBankAccount coreAccount){
        base = coreAccount;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE);
    }
}
