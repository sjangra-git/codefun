package codefun;

import java.util.Arrays;

public class ConsecutiveElemSum
{

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(sumOfConsecutiveElements(new int[]{1,3,5,7,9}, 15)));
    }
    
    private static int[] sumOfConsecutiveElements(int[] array, int n)
    {
        
        
        for (int i=0; i< array.length; i++)
        {
            int sum = array[i];
            for (int j=i+1; j< array.length; j++)
            {
                sum += array[j];
                if(sum == n) 
                {    
                    int[] results = new int[j-i+1];
                    System.arraycopy(array, i, results, 0, j-i+1);
                    return results;
                }
                else if (sum > n)
                {
                    // stop going forward
                    break;
                }
            }
        }
        
        return null;
    }
}
