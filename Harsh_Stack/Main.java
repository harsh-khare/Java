package Harsh_Stack;

import java.util.*;
class Main
{
    public static void main(String[] args) throws Exception
    {
        DynamicStack stack = new DynamicStack(5); 

        stack.push(35);
        stack.push(92);
        stack.push(82);
        stack.push(56);
        stack.push(20);
        stack.push(23);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}






