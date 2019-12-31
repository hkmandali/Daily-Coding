package DailyCoding;

import java.util.Random;

/*
Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */
// this code has been seen from gfg
public class Day15 {
    static int count =0;
    static int result;
    static int findrandom(int input)
    {

        ++count;
        if(count ==1)
            result = input; // as it is the only element
        else
        {
            int random = new Random().nextInt() % count; // this will actually give the values from 0 to count -1
            if(random == count-1)
                result = input;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8};
        for(int i=0;i<arr.length;++i)
        {
            System.out.println("the rand number is "+ findrandom(arr[i]));
        }
    }
}
