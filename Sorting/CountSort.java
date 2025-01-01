package Sorting;
import java.util.*;;
public class CountSort 
{
    public static void main(String[] args) 
    {
        int[] arr = {1, 5, 4, 4, 4, 3, 2, 9, 6, 8, 7, 7, 7, 9};
        int[] arr1 = {1, 5, 4, 4, 4, 3, 2, 9, 6, 8, 7, 7, 7, 9};
        countSort(arr);
        countSortHash(arr1);
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    static void countSort(int[] arr)
    {
        if(arr == null || arr.length<=1)
        return;
        
        int max = arr[0];
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>max)
            max = arr[i];
        }

        int[] cArr = new int[max+1];
        for(int n:arr)
        {
            cArr[n]++;
        }

        int index=0;
        for(int i=0; i<=max; i++)
        {
            while(cArr[i]>0)
            {
                arr[index] = i;
                index++;
                cArr[i]--;
            }
        }
    }

    static void countSortHash(int[] arr)
    {
        if(arr==null || arr.length<=1)
        return;
        
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:arr)
        {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        int index = 0;
        for(int i=min; i<=max; i++)
        {
            int count = countMap.getOrDefault(i,0);
            for(int j=0; j<count; j++)
            {
                arr[index] = i;
                index++;
            }
        }
    }
}
