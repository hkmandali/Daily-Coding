package DailyCoding;
/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
 */
public class Day9 {
    static int findmaxextra(int[] input) // with extra memory
    {
        int[] maxarr = new int[input.length];
        maxarr[0] = input[0];
        maxarr[1] = Math.max(maxarr[0],input[1]);
        for(int i=2;i<input.length;++i)
        {
            maxarr[i] = Math.max(maxarr[i-2]+input[i],maxarr[i-1]);
        }

        return maxarr[input.length-1];
    }
    static int findmax(int[] input) // without extra memory
    {
        int maxtillprev,max,max2; // max --> max till current , maxtillprev -- > max till prev index , max2 --> till previous 2 indices
        max = input[0];
        max2 = input[0];
        maxtillprev = Math.max(input[0],input[1]);
        for(int i=2;i<input.length;++i)
        {
            max = Math.max(max2+input[i],maxtillprev);
            max2 =maxtillprev;
            maxtillprev= max;
        }
        return max;
    }
    public static void main(String[] args)
    {
        //we can do this using d.p with extra memory , we will store the max till that index without adjacent
        int[] arr = {5,1,-6,-1,-5,2,-3,-6};
        int res = findmaxextra(arr);
        System.out.println("the max sum formed is "+res);
        int res1 = findmax(arr);
        System.out.println("the max sum formed without extra mem is "+res1);
    }
}
