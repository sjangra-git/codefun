package codefun;

import java.util.Arrays;

// Rotate array to right by 'k' times
public class RotateArray
{

    public static void main(String[] args)
    {
        int[] array = new int[]{1,2,3,4,5};
        rotateArraySolution1(array, 1);        
    }
    
    // Time - O(n*k)
    private static void rotateArraySolution1(final int[] input, int k)
    {
        if(input == null || k < 0)
        {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int length = input.length;
        int modified_k = k % length;
        
        for(int i=0; i<modified_k; i++)
        {
            rotate(input);
        }
        
        System.out.println(Arrays.toString(input));
    }
    
    private static void rotate(final int[] array)
    {
        int length = array.length;
        int last = array[length-1];
        
        for(int i = length-1; i>-1; i--)
        {
            if(i==0)
            {
                array[i] = last;
            }
            else 
            {
                array[i] = array[i-1];
            }
        }        
    }
}
