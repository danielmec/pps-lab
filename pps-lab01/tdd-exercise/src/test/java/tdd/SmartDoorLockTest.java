package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private  SmartDoorLock door ;
    private final int  pin=1223;
    private final int wrongPin=3453;

    @Test
    public void todo() {
        assertTrue(true);
    }

    @BeforeEach
    void init(){
        door = new SmartDoorLockImpl();
    }

    @Test
    void testSetPin(){
        assertFalse(door.isBlocked());
        assertFalse(door.isLocked());
        door.setPin(pin);
        assertTrue(door.isLocked());
    }

    @Test
    void testUnlock()
    {
        door.setPin(pin);
        door.unlock(pin);
        assertFalse(door.isLocked());
    }

    @Test
    void testUnlockWithWrongPin()
    {
        door.setPin(pin);
        door.unlock(wrongPin);
        assertTrue(door.isLocked());
        assertEquals(1,door.getFailedAttempts());
    }


    @Test
    void testLock(){
        door.setPin(pin);
        assertTrue(door.isLocked());
    }

    @Test
    void testLockWithoutPin(){
        assertThrows(IllegalStateException.class, ()-> door.lock());
    }

    @Test
    void testIsLocked()
    {
        door.setPin(pin);
        assertTrue(door.isLocked());
    }

    @Test
    void testIsBlocked()
    {
        door.setPin(pin);
        for(int i=0;i<door.getMaxAttempts();i++)
        {
            door.unlock(wrongPin);
        }

        assertTrue(door.isBlocked());
    }

    @Test
    void testGetFailedAttempts(){
        door.setPin(pin);
        door.unlock(wrongPin);
        assertEquals(1,door.getFailedAttempts());
        door.unlock(wrongPin);
        assertEquals(2,door.getFailedAttempts());
    }

    @Test
    void testReset()
    {
        door.setPin(pin);
        door.unlock(wrongPin);
        door.reset();
        assertFalse(door.isBlocked());
        assertFalse(door.isLocked());
        assertEquals(0,door.getFailedAttempts());
    }


}
