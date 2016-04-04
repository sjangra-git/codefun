package codefun;

import java.util.Arrays;

public class MergeTwoArrays<T extends Comparable<T>>
{

    public static void main(String[] args)
    {
        int[] result = mergeArrays(new int[]{5,2,1,3}, new int[]{6,12,2,9,20, 5});
        System.out.println(Arrays.toString(result));
        mergeArrays(new int[]{5,2,1,3}, null);
    }
    
    /**
     * Merge two unsorted arrays into a sorted array without any duplicates.
     * @param array1
     * @param array2
     * @return
     */
    public static int[] mergeArrays(int[] array1, int[] array2)
    {
        // Error checks
        if(array1 == null || array2 == null) throw new IllegalArgumentException("One of the array is null");                
        
        // Create the result. Initializing it with the l1 + l2, might produce trailing zeros, if the two arrays have same int.
        // Coz then result array size will be smaller.
        int[] result = new int[array1.length + array2.length];
        
        // Sort the arrays
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        // Now merge 
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<array1.length && j<array2.length)
        {
            if(array1[i] < array2[j])
            {
                result[k] = array1[i];
                i++;
                k++;
            }
            else if(array1[i] > array2[j])
            {
                result[k] = array2[j];
                j++;
                k++;
            }
            else
            {
                // Both equal
                result[k] = array1[i];
                i++;
                j++;
                k++;
            }
        }
        
        System.out.println(Arrays.toString(result));
        // Copy all of array1 if not already done
        while(i<array1.length)
        {
            result[k] = array1[i];
            i++;
            k++;
        }
        System.out.println(Arrays.toString(result));        
        // Copy all of array2
        while(j<array2.length)
        {
            result[k] = array2[j];
            j++;
            k++;
        }
        
        System.out.println(Arrays.toString(result));

        // This will make sure we trim the array to its size
        return Arrays.copyOf(result, k);
    }
}
