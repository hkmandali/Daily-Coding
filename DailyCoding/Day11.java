package DailyCoding;

import src.Trie.Trie;
import java.util.LinkedList;
import java.util.List;

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

        For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

        Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

*/
public class Day11 {

    static boolean nomoreChildren(Trie curr) // checks if it is the last node
    {
        for(int i=0;i<curr.children.length;++i)
        {
            if(curr.children[i] != null)
                return false;
        }
        return true;
    }

    static void nextwords(Trie Head,List<String> output,String prefix)
    {
        String input = prefix;

        if(Head.end_of_word) // if it is the end of word return
        {
            output.add(prefix);
            return;
        }


        for(int i=0;i<26;++i)
        {
            if(Head.children[i] != null) // if it has children
            {

                char tostring = (char)(i+'a');
                String currpefix = prefix + tostring;
                System.out.println("current prefix is "+tostring);
                nextwords(Head.children[i],output,currpefix);
            }
        }

    }

    static List<String> autocomplete(Trie Head,String prefix)
    {
        System.out.println("autocomplete with prefix "+prefix);
         List<String> output = new LinkedList<>();
        if(Head == null)
        {
            System.out.println("Head is null");
        }
         Trie itr = Head; // this will iterate throughout the trie
         int len = prefix.length();

         for(int i=0;i<len;++i)
         {
             System.out.println("i is "+i);
             int curr_index = prefix.charAt(i) -'a';
            if(itr.children[curr_index] == null)
                return null; // as there are no enough characters in the trie
             itr = itr.children[curr_index];
         }

         // now we have parsed the entire prefix , if doesnt has any children and it is the end of word , we return the string prefix else we recursively call the function to prtin all of them

        boolean is_prefix_a_word = itr.end_of_word; // this checks if the given prefix is a word

        boolean no_children = nomoreChildren(itr); // this tells us if it has any more children or not
        System.out.println("is_prefix_a_word "+is_prefix_a_word+"   no children " +no_children);
        if(is_prefix_a_word && no_children) // if the given prefix is a word and there are no more children , store it and return
        {
            output.add(prefix);
        }
        else // it is not the last node and has children
        {
            nextwords(itr,output,prefix);
        }

         return output;
    }

    public static void main(String[] args)
    {
        Trie.Head = new Trie();
        Trie obj =Trie.Head;
        String[] input = {"dog","deer","deal"};

        for(int i=0;i<input.length;++i) // we now store the strings into trie
        {
            Trie.insertNode(input[i]);
        }

        // now if we pass any string as input it should return all the words starting with that

        List<String> output = autocomplete(Trie.Head,"dee");

        for(String s:output)
          System.out.println(s); // this will print all the strings with the given prefix


    }
}
