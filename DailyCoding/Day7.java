package DailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class Day7 {
    static int findways(String input)
    {
        int len = input.length();
        int[] numways = new int[len]; // this gives us the number of ways a string can be decoded
        if(input.charAt(0) == '0')
        {
            numways[0] =0;
            numways[1] =1; // as all messages are decodable , there is no 00 case
        }
        else
        {
            numways[0] =1;// as there is only one way a single character can be decoded
            if(input.charAt(0) -'0' < 2 || (input.charAt(0) -'0' == 2 && input.charAt(1) -'0' < 7))
            {
                numways[1] = 2;
            }
            else
            {
                numways[1] = 1;
            }
        }

        for(int i=2;i<len;++i)
        {
            int current = input.charAt(i) -'0';// this gives the current character
            if(input.charAt(i-1) -'0' < 2 || (input.charAt(i-1) -'0' == 2 && input.charAt(i) -'0' < 7))// a vlaid string can be formed with old and the new one as well , from 0 -19 i.e with second character included and 20 -26
            {
                numways[i] = numways[i-1] + numways[i-2];
            }
            else
            {
                numways[i] = numways[i-2];
            }

        }
        return numways[len-1];
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println("enter the input string");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int res = findways(input);
        System.out.println("the num ways are "+res);
    }
}
