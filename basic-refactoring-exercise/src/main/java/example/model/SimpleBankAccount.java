package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    private final double FEE=1;
    private final int MinAmount =  0;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && amount > MinAmount) {
            this.balance += amount;
        }else {
            throw new IllegalArgumentException("Deposit must be positive and higher than the minimum amount");
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    @Override
    public void withdrawWithFee(int userID, double amount) {
        if(checkUser(userID) && isWithdrawAllowedWithFee(amount))
        {
            this.balance -= amount+FEE;
        }else
        {
            throw new IllegalArgumentException("Withdrawal amount exceeds balance");
        }
    }

    private boolean isWithdrawAllowedWithFee(final double amount) {
        if(this.balance>amount+FEE)
        {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
