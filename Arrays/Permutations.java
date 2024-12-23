package Arrays;
import java.util.*;

public class Permutations 
{
    public static void main(String[] args) 
    {
        System.out.println(permute(new ArrayList<>(), 0, new int[]{1,2,3}));
    }   
    
    static List<List<Integer>> permute(List<Integer> p, int ind, int[] nums) 
    {
        if(ind == nums.length)
        {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            list.add(p);
            return list;
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int n = nums[ind];

        for(int i=ind; i<nums.length; i++)
        {
            p.add(nums[i]);
            ans.addAll(permute(p, ind+1, nums));
            
        }

        return ans;
    }
}
