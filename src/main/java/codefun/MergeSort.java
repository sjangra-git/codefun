package codefun;

import java.util.Arrays;

public class MergeSort
{

    public static void main(String[] args)
    {
        int[] array = new int[]{2,1,3,9,6,5};
        mergeSort(array, 0, array.length-1);
        
        System.out.println(Arrays.toString(array));
    }
    
    private static void mergeSort(int[] array, int start, int end)
    {
        if(start==end)
        {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);        
    }
    
    // merge two sorted arrays
    private static void merge(int[] array, int start, int mid, int end)
    {
        // Initialize the result array
        int[] result = new int[end-start+1];

        // Keep two pointers at the beginning of each array and put smallest of the two into the resulting array
        int i = start, j=mid+1, k=0;
        while(i< mid+1 && j<end+1)
        {
            if(array[i] <= array[j])
            {
                result[k] = array[i];
                i++;
            }
            else 
            {
                result[k] = array[j];
                j++;
            }
            k++;
        }
        
        // If array1 is left from merging
        if(i<mid+1) 
        {
            System.arraycopy(array, i, result, k, mid-i+1);
        }
        else if(j<end+1)
        {
            System.arraycopy(array, j, result, k, end-j+1);
        }
        
        int t=0;
        // Copy the result array into main array between positions start..end
        for(int m = start; m<end+1; m++)
        {
            array[m] = result[t++];
        }
    }
}
