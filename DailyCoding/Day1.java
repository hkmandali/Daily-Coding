package DailyCoding;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
*/
public class Day1 {
  public static void main(String[] args) throws IOException
  {
      int[] arr = {10,15,10,3,7,2,10};
      HashMap<Integer,Integer> map = new HashMap<>();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("enter the required sum");
      int sum = Integer.parseInt(br.readLine());
      for(int i=0;i<arr.length;++i)
      {

          if(map.containsKey(sum-arr[i]))
          {
              System.out.println("the two nums are "+arr[i] +"  "+(sum-arr[i]));
          }
          map.put(arr[i],arr[i]); // here value doesnt matter anyways , if distinct combinations are required -- add an else case for this statement
      }
  }
}
