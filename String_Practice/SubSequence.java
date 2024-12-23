package String_Practice;
import java.util.*;

public class SubSequence 
{
    public static void main(String[] args) 
    {
        
        System.out.println(count(7));
    }
    
    static List<String> subSet(String p, String up)
    {
        if(up.isEmpty() )
        {
            List<String> list = new ArrayList<String>();
            if(!p.isEmpty())
            {list.add(p);}
            return list;
        }

        char ch = up.charAt(0);
        List<String> ans = new ArrayList<String>();

        ans.addAll(subSet(p+ch, up.substring(1)));
        ans.addAll(subSet(p, up.substring(1)));

        return ans;
    } 

    static List<String> subSeq(String p, String up)
    {
        if(up.isEmpty())
        {
            List<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>();

        for(int i=0; i<=p.length(); i++)
        {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(subSeq(f+ch+s,up.substring(1)));
        }

        return ans;
    }

    static int count(int n)
    {
        int c=0;
        while(n>0)
        {
            if((n&1) == 1)
            c++;

            n = n>>1;
        }
        return c;
    }

}
