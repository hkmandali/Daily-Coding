package DailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".


 */
public class Day13 {
    static boolean isunique(int[] count,int k)
    {
        int count_unique=0; // total number of unique characters in the array
        for(int i=0;i<count.length;++i)
        {
            if(count[i] > 0)
                count_unique++;
        }
        if(count_unique <= k)
            return true;
        return false;
    }
    static int longestsubstring(String input,int k)
    {
        int len = input.length();
        int max_len =0,start=0,end=0;
        int final_start=0;
        int[] count_char = new int[26]; // this array contains the count of each character from a-z
        //we can  first check if the number of unique characters are less than k ,then we return zero

        for(int i=0;i<len;++i)
        {
            int current = input.charAt(i) - 'a';
            System.out.println("current character uni is "+current);
            count_char[current]++;
            end++;

            if(!isunique(count_char,k)) // if the characters are not unique , remove from the beginning
            {
                count_char[input.charAt(start) -'a']--;
                start++;
            }
            if(end - start > max_len)
            {
                max_len = end - start;
                final_start = start;
            }

        }
        System.out.println("the final string is "+input.substring(final_start,final_start+max_len));
        return max_len;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the string and value of k");
        String input = br.readLine();
        int distinct = Integer.parseInt(br.readLine());
        int res = longestsubstring(input,distinct);
        System.out.println("the lingest substring len is "+res);
    }
}
