package DailyCoding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Given a list of words, return the shortest unique prefix of each word. For example, given the list:

dog
cat
apple
apricot
fish
Return the list:

d
c
app
apr
f
 */
public class Day162 {
    public static void main(String[] args)
    {
        String[] input = {"dog","cat","apple","apricot","fish"};
        String[] res = new String[input.length];
        Set<String> obj = new HashSet<>();
        for(int i=0;i<input.length;++i)
        {
            String current = input[i];
            int curr_len = current.length();
            String formed = new String();
            for(int j=0;j<curr_len;++j)
            {
                char curre_char = current.charAt(j);
                System.out.println("current char is "+curre_char);
                formed += curre_char;
                if(!obj.contains(formed))
                {
                    obj.add(formed);
                    res[i] = formed;
                    break;
                }
            }
        }
        // some improvements need to be made
        System.out.println("the output is ");
        for(int i=0;i<input.length;++i) {
            System.out.println(res[i]);
        }

        // this can be solved using tries , similar to Day11 ,
        // but we need to keep track of the number of times a node is visited , this can be done by keeping an extra variable called freq in the trie class

    }
}
