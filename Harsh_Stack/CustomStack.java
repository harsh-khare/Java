package Harsh_Stack;

public class CustomStack 
{
    public int[] data;
    static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack()
    {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size)
    {
        this.data = new int[size];
    }

    public boolean push(int item)
    {
        if(isFull())
        {
            System.out.println("Stack is full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    int pop() throws StackException
    {
        if(isEmpty())
        {
            throw new StackException("Cannot pop from an empty Stack!!");
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    int peek() throws StackException
    {
        if(isEmpty())
        {
            throw new StackException("Cannot peek from an empty Srtack!!");
        }

        return data[ptr];
    }

    public boolean isFull()
    {
        return ptr == data.length-1;
    }

    boolean isEmpty()
    {
        return ptr == -1;
    }
}
