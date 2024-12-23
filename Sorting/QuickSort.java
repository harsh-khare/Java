package Sorting;

import java.util.*;
public class QuickSort 
{
    public static void main(String[] args) 
    {
        int[] arr = {5,4,3,2,1, 7, 8, 5 , 9, 10 ,11};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));        
    } 
    
    static void sort(int[] arr, int low, int hi)
    {
        if(low>=hi)
        return;

        int s = low;
        int e = hi;
        int mid = (s + e)/2;

        int piv = arr[mid];

        while(s<=e)
        {
            while(arr[e]>piv)
                e--;

            while(arr[s]<piv)
                s++;

            if(s<=e)
            {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        sort(arr, low, e);
        sort(arr, s, hi);
    }
}
