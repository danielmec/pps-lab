package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    private int pin;
    private boolean isLocked;
    private boolean isBlocked;
    private final int maxAttempts= 3;
    private int failedAttempts;

    public  SmartDoorLockImpl(){
        isBlocked=false;
        isLocked=false;
        failedAttempts=0;
    }


    @Override
    public void setPin(int pin) {
        if(!this.isLocked)
        {
            this.pin=pin;
            this.isLocked=true;
        }

    }

    @Override
    public void unlock(int pin) {
        if(!this.isBlocked) {
            if (this.pin == pin) {
                this.isLocked = false;
            } else {
                failedAttempts++;
                if (failedAttempts == maxAttempts) {
                    this.isBlocked = true;
                }
            }
        }else
        {
            throw new IllegalStateException("Door is blocked");
        }
    }

    @Override
    public void lock() {
        if(this.pin!=0)
        {
            this.isLocked=true;
        }else {
            throw new IllegalStateException("Pin is not set");
        }

    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {
        this.pin=0;
        this.isBlocked=false;
        this.isLocked=false;
        this.failedAttempts=0;
    }
}
