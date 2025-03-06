package e1;

public class BronzeBankAccount implements BankAccount{

    private final CoreBankAccount base;
    private static final int MaxWithdrawWithoutFee=100;
    private static final int FEE= 1;
    public BronzeBankAccount(CoreBankAccount core){
        base=core;
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if((base.getBalance()-amount)<0)
        {
            throw new IllegalArgumentException("Balance insufficient");
        }
        if(amount<=MaxWithdrawWithoutFee){
            base.withdraw(amount);
        }else{
            if((base.getBalance()-(amount+FEE))<0)
            {
                throw new IllegalArgumentException("Balance insufficient");
            }
            base.withdraw(amount+FEE);
        }
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }
}
