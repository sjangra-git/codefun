package codefun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/3sum/
public class SumOfThree
{

    public static void main(String[] args)
    {
        int[] array = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(get3Sum(array));
    }
    
    private static Set<String> get3Sum(int[] input)
    {
        Set<String> result = new HashSet<String>();
        
        for(int i = 0; i< input.length - 2; i++)
        {
            for(int j = i+1; j<input.length - 1; j++)
            {
                for(int k = j+1; k<input.length; k++)
                {
                    if( (input[i] + input[j] + input[k]) == 0)
                    {
                        int[] res = new int[3];
                        res[0] = input[i];
                        res[1] = input[j];
                        res[2] = input[k];
                        Arrays.sort(res);
                        result.add(Integer.toString(res[0]) +"," + Integer.toString(res[1]) + "," + Integer.toString(res[2]));
                    }
                }
            }
        }
        return result;
    }
}
