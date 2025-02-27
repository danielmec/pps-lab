package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularQueueImpl circularQueue;

    private final int firstValue = 31;
    private final int secondValue = 43;
    private final int thirdValue = 27;
    private final int fourthValue = 55;

    @BeforeEach
    void init() {
        circularQueue = new CircularQueueImpl();
    }

    @Test
    public void testPush() {
        circularQueue.push(firstValue);
        assertEquals(firstValue, circularQueue.getElement(0));
        assertEquals(1, circularQueue.getSize());
    }

    @Test
    public void testPop() {
        circularQueue.push(firstValue);
        circularQueue.push(secondValue);
        int popped = circularQueue.pop();

        assertEquals(firstValue, popped);

        assertEquals(1, circularQueue.getSize());
    }

    @Test
    public void testPeek() {
        circularQueue.push(firstValue);
        int peeked = circularQueue.peek();
        assertEquals(firstValue, peeked);
        assertEquals(1, circularQueue.getSize());
    }

    @Test
    public void testGetMax() {
        circularQueue.push(firstValue);   // 31
        circularQueue.push(secondValue);  // 43
        circularQueue.push(thirdValue);   // 27

        assertEquals(secondValue, circularQueue.getMax());
    }

    @Test
    public void testGetMin() {
        circularQueue.push(firstValue);   // 31
        circularQueue.push(secondValue);  // 43
        circularQueue.push(thirdValue);   // 27

        assertEquals(thirdValue, circularQueue.getMin());
    }

    @Test
    public void testIsEmpty() {

        assertTrue(circularQueue.isEmpty());
        circularQueue.push(firstValue);

        assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testGetMaxSize() {

        assertEquals(3, circularQueue.getMaxSize());
    }

    @Test
    public void testCircularPush() {

        circularQueue.push(firstValue);
        circularQueue.push(secondValue);
        circularQueue.push(thirdValue);
        circularQueue.push(fourthValue);
        int popped = circularQueue.pop();
        assertEquals(secondValue, popped);
    }
}
