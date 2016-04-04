package codefun;

/**
 * https://leetcode.com/problems/create-maximum-number/
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. 
 * The relative order of the digits from the same array must be preserved. 
 * Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

TODO - NOT DONE
 */
public class CreateMaximumNumber
{

    public static void main(String[] args)
    {
        
    }
    
    public static int maximumNumber(int[] array1, int[] array2, int k)
    {
        int max = -1;
        
        return max;
    }
    
    public static int getMaximum(Node[] array, int[] result, int currPosInRes, int nodePos, int posA, int posB)
    {
        // return 
        
        return -1;
    }
    
    class Node implements Comparable<Node>
    {
        int val;
        int arrayNum;
        int posInArray;
        
        public int compareTo(Node o)
        {
            return Integer.compare(val, o.val);
        }
        
    }
}
