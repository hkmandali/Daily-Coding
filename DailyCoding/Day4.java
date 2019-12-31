package DailyCoding;

import java.util.Arrays;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
 */
public class Day4 {
    static int findminNotpresent(int[] arr)
    {
        int min =0;
        int i=0,j=arr.length-1;

        while(i<=j)
        {
            if(arr[i] < 0)
                i++;
            else {
                if(arr[j] < 0) // swap arr[i] and arr[j]
                {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] -arr[j];
                    arr[i] = arr[i] - arr[j];
                    i++;
                    j--;
                }
                else
                {
                    --j;
                }
            }
        }
        // now we have the sorted array
        //System.out.println(" the sorted array now is "+ Arrays.toString(arr) +"  i is "+i); // now from i to arr.length , there are only positive numbers
        int len = arr.length;
        if(i == len|| (i == len -1 && arr[i] != 1))
        {
            System.out.println("least not present is  "+1);
            return 1;
        }
        for(j=i;j<len;++j) // counter variable is j
        {
            if(  Math.abs(arr[j])-1 < len && arr[Math.abs(arr[j]-1+i)] >= 0)
            {
               // System.out.println("Math.abs(arr[j]-1+i)   is "+(Math.abs(arr[j]-1+i)) + "    j =   "+j);
                arr[Math.abs(arr[j])-1+i] = -arr[Math.abs(arr[j])-1+i];
            }
        }
        min = len +1;
        for(j=i;j<len;++j)
        {
            if(arr[j] > 0)
                return j+1-i;
        }
        return min;
    }
    public static void main(String[] args)
    {
        int[] arr = {-10,45,-56,-1,2,-3,-1}; // if the array contains only positive numbers we can do this by negating the numbers with indices-1
        // with negative this cant be applied as we are not sure if the num is -ve or +ve
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        // we have discussed one of the methods in package Arrays , the other method being we segregate the +ve and -ve and perform operation only on the +ve
        int res = findminNotpresent(arr);
        System.out.println("Not present is "+ res);


    }
}
