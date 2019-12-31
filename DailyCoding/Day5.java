package DailyCoding;

/*
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.
 */
public class Day5 {
    public static void main(String[] args)
    {
        System.out.println("this is just a nested function in python");
        /*
            if we are able to call cons directly , it is creating a nested function inside it which calls it
            def car(pair)
                def first_element(a,b)
                    return a
                return pair(first_element) // pair first element will call the pair f in line 9 , which will in turn call first_element in line 21


            def cdr(pair)
                def last_element(a,b)
                    return b
                 return pair(last_element) // pair last element will call the pair f in line 9 , which will in turn call last_element in line 27
         */
    }
}
