package codefun;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

    https://leetcode.com/problems/largest-number/
 *
 */
public class LargestNumber
{

    public static void main(String[] args)
    {
        Integer[] array = new Integer[] {3,30,34,5,9};
        System.out.println(largestNumber(array));
    }
    
    private static String largestNumber(Integer[] array)
    {
        String result = "";
        
        Comparator<Integer> strComparator = new Comparator<Integer>() {
          public int compare(Integer a, Integer b)
          {
              String aStr = a.toString();
              String bStr = b.toString();
              Integer option1 = Integer.valueOf(aStr + bStr);
              Integer option2 = Integer.valueOf(bStr + aStr);
              
            if(option1 > option2)
                return 1;
            else if(option1 < option2)
                return -1;
            else 
            return 0;  
          }
        };
                
        Arrays.sort(array, strComparator);
        
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i>-1; i--)
        {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
