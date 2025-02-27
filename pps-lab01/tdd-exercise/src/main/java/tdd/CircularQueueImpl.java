package tdd;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class CircularQueueImpl implements CircularQueue {

    private ArrayList<Integer> circularQueue;
    private final int MAXSIZE = 3;
    private int size;
    private int head; // index of the oldest element
    private int tail; // index of next element to insert

    public CircularQueueImpl() {
        circularQueue = new ArrayList<>(MAXSIZE);

        for (int i = 0; i < MAXSIZE; i++) {
            circularQueue.add(null);
        }
        size = 0;
        head = 0;
        tail = 0;
    }


    @Override
    public void push(int value) {

        circularQueue.set(tail, value);

        if (size == MAXSIZE) {
            head = (head + 1) % MAXSIZE;
        } else {
            size++;
        }

        tail = (tail + 1) % MAXSIZE;
    }


    @Override
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }

        int element = circularQueue.get(head);
        circularQueue.set(head, null);

        head = (head + 1) % MAXSIZE;
        size--;
        return element;
    }


    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return circularQueue.get(head);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getElement(int index) {
        return circularQueue.get(index);
    }

    @Override
    public int getMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        int max = peek();

        for (int i = 0; i < size; i++) {
            int index = (head + i) % MAXSIZE;
            int value = circularQueue.get(index);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public int getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        int min = peek();
        for (int i = 0; i < size; i++) {
            int index = (head + i) % MAXSIZE;
            int value = circularQueue.get(index);
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getMaxSize() {
        return MAXSIZE;
    }
}
