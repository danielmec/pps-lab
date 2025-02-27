package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @Test
    public void todo() {
        assertTrue(true);
    }

    private MinMaxStack stack;
    private final int value=21;

    @BeforeEach
    void init(){
        stack=new MinMaxStackImpl();

    }

    @Test
    void testPush()
    {
        stack.push(value);
        assertEquals(value,stack.peek());
        assertEquals(0,stack.size()-1);
    }

    @Test
    void testPop(){
        stack.push(value);
        assertEquals(value,stack.pop());
        assertEquals(-1,stack.size()-1);
    }

    @Test
    void testPeek()
    {
        stack.push(value);
        assertEquals(value,stack.peek());
    }

    @Test
    void testGetMin()
    {
        stack.push(value);
        stack.push(2*value);
        stack.push(value-3);
        assertEquals(value-3,stack.getMin());
    }

    @Test
    void testGetMax()
    {
        stack.push(value);
        stack.push(2*value);
        stack.push(value-3);
        stack.push(3*value);
        assertEquals(3*value,stack.getMax());
    }

    @Test
    void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsNotEmpty()
    {
        stack.push(value);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize()
    {
        stack.push(value);
        stack.push(value);
        stack.push(value);
        stack.pop();
        assertEquals(2,stack.size());
    }

}