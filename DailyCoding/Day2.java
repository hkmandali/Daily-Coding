package DailyCoding;

import java.util.Arrays;

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class Day2 {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        // as we cant use division , we need to maintain two arrays , one for left product i.e product of all the numbers to the left of it , and one for right product
        int[] leftprod = new int[arr.length];
        int[] rightprod = new int[arr.length];
        int[] mularr = new int[arr.length]; // this array has the final product
        leftprod[0] =1; // as there are no nums to the left of first and right of last
        rightprod[arr.length -1 ] =1;
        for(int i=1;i<arr.length;++i)
        {
            leftprod[i] =leftprod[i-1] * arr[i-1];
            rightprod[arr.length -i-1] = rightprod[arr.length -i ] * arr[arr.length -i];
        }
        for(int i=0;i<arr.length;++i)
        {
            mularr[i] = leftprod[i] * rightprod[i];
        }
        System.out.println("the final array is "+ Arrays.toString(mularr));
    }
}
