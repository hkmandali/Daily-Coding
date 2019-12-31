package DailyCoding;

import java.util.Stack;

/*
Given an arithmetic expression in Reverse Polish Notation, write a program to evaluate it.

The expression is given as a list of numbers and operands. For example: [5, 3, '+'] should return 5 + 3 = 8.

For example, [15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'] should return 5, since it is equivalent to ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1)) = 5.

You can assume the given expression is always valid.
 */
public class Day163 {
    // this is similar to post fix evaluation , we can evaluate it using stacks
    public static void main(String[] args)
    {
        char[] arr = {15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'} ;
        Stack<Integer> s = new Stack();
        int len = arr.length;
        s.add((int)arr[0]);
        int res =0;

        for(int i=1;i<len;++i)
        {
            char current = arr[i] ;
            int first;
            int second ;
            int result = 0;
            if(current == '+' || current == '/' ||current == '-'||current == '*') {
                first = s.pop();
                second = s.pop();
                switch (current) {
                    case '+': {
                        result = second + first;
                        break;
                    }
                    case '-': {
                        result = second - first;
                        break;
                    }
                    case '/': {
                        result = second / first;
                        break;
                    }
                    case '*': {
                        result = second * first;
                        break;
                    }
                }
                s.add(result);
            }
            else
            {
                s.add((int)arr[i]);
            }
        }
        res = s.pop();
        System.out.println("the final result is "+res);

    }
}
