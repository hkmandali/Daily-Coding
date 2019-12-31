package DailyCoding;

import java.util.LinkedList;
import java.util.List;

/*
Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.
 */
public class Day17 {
    static int longestpath(String input)
    {
        int max_len =0;
        if(input.length() == 0)
            return 0;
        String[] split = input.split("\\\\n"); // as there are two \\ , we need to ignore two so place 4 in the regex
        List<String> pathtillNow = new LinkedList<>();
        for(String s : split) // this gives us the different directories i.e we have splitted the string
        {
            System.out.println(s);
            int numtabs = Math.max(0,s.lastIndexOf("\\t")); // this tells us the path of last index of tab in that substring
            String currpath = s.substring(numtabs+1);
            System.out.println("num of tabs is "+numtabs);
            System.out.println("current path  is "+currpath);
            pathtillNow = pathtillNow.subList(0,numtabs);
            pathtillNow.add(currpath);
            //System.out.println("path till now "+pathtillNow);
            int current_Len = pathtillNow.stream().mapToInt(String::length).sum();
            max_len = Math.max(max_len,current_Len);

        }


        return max_len;
    }
    public static void main(String[] args)
    {
        String input ="dir\\n\\tsubdisdfr1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
        String test = "\n\t\t\tfile2.ext";
        System.out.println("num tabs are "+test.lastIndexOf('\t'));
        int len = longestpath(input);
        //System.out.println("longest path is "+len);
    }
}
