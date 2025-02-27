package tdd;

import java.util.ArrayList;


public class MinMaxStackImpl implements MinMaxStack {


    private ArrayList<Integer> stack ;
    private int indexOfLastValue;


    public MinMaxStackImpl()
    {
        stack= new ArrayList<>();
        indexOfLastValue=-1;
    }


    @Override
    public void push(int value) {
        stack.add(value);
        indexOfLastValue++;
    }

    @Override
    public int pop() {
        return stack.get(indexOfLastValue--);
    }

    @Override
    public int peek() {
        return stack.get(indexOfLastValue);
    }

    @Override
    public int getMin() {
        int min =stack.get(0);
        for(Integer num: stack)
        {
            if(num < min )
            {
                min=num;
            }
        }
        return min ;
    }

    @Override
    public int getMax() {
        int max = stack.get(indexOfLastValue);
        for(int i =0;i<=indexOfLastValue;i++)
        {
            if(stack.get(i)>max)
            {
                max=stack.get(i);
            }
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return indexOfLastValue < 0;
    }

    @Override
    public int size() {
        return indexOfLastValue+1;
    }
}
