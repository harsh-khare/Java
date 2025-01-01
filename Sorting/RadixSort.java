package Sorting;

import java.util.*;
public class RadixSort 
{
    public static void main(String[] args) 
    {
        int[] arr = {29, 83, 471, 36, 91, 8};

        System.out.println("\n Original Array" + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("\nSorted Array" + Arrays.toString(arr)+"\n");
    }   
    
    static void radixSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        for(int i=1; max/i>0 ; i*=10)
        {
            countSort(arr, i);
        }
    }

    static void countSort(int[] arr, int exp)
    {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++)
        {
            count[(arr[i]/exp)%10]++;
        }

        System.out.println("\nCount array for "+ exp + ":"+ Arrays.toString(count));

        for(int i=1; i<10; i++)
        {
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated array for "+ exp + ":" +Arrays.toString(count));

        for(int i=n-1; i>=0; i--)
        {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;            
        }

        System.arraycopy(output, 0, arr, 0,  n);
    }
}
