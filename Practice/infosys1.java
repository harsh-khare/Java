package Practice;

import java.util.*;
public class infosys1 
{
    public static void main(String[] args) 
    {
        String s = "110";
        System.out.println();
        System.out.println("Ans is: "+operations(s));        
    }
    
    static String operations(String s)
    {
        StringBuilder ans = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i=1; i<s.length(); i++)
        {
            if(!stack.isEmpty() && stack.peek()=='1' && s.charAt(i)=='0')
            {
                stack.pop();
                i--;
            }
            else
            stack.push(s.charAt(i));
        }

        int size = stack.size();

        while (!stack.isEmpty()) 
            ans.insert(0, stack.pop());

        return ans.toString();
    }
}
