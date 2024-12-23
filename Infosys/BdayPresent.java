package Infosys;

import java.util.*;
public class BdayPresent 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(count(1, n, k, 0));
    }    

    static int count(int t, int n, int k, int c)
    {
        if(t>n)
        return c;

        int num = t;
        int i=1, f=1;

        while(i<k)
        {
            if(num*f <=n)
            {
                num = num * f; 
                f++;
                i++;
            }
            else
            break;
        }

        if(i==k)
        return count(t+1, n, k, c+1);
        else
        return count(t+1, n, k, c);
    }
}
