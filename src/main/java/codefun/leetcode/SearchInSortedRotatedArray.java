package codefun.leetcode;

import java.util.Arrays;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {

		int[] arr = new int[] {7, 0, 1, 2, 3, 4, 5, 6};
		int loc1 = searchInRotatedSortedArray(arr, 6);
		if(loc1 != 7)
		{
			System.err.println("Number 6 not found, returned: " + loc1);
		}

		arr = new int[] {4,5,6,7,0,1,2};
		loc1 = searchInRotatedSortedArray(arr, 3);
		if(loc1 != -1)
		{
			System.err.println("Number 3 not found, returned: " + loc1);
		}

		arr = new int[] {1};
		loc1 = searchInRotatedSortedArray(arr, 0);
		if(loc1 != -1)
		{
			System.err.println("Number 0 not found, returned: " + loc1);
		}
	}

	public static int searchInRotatedSortedArray (int[] arr, int target)
	{
		// Find the position of the maximum
//		int maxLoc = findPosOfMaxUsingLinearComplexity(arr);
		int maxLoc = findPosOfMaxUsingBinaryComplexity(arr, 0, arr.length - 1);

		System.out.format("Debug: maxLoc %d ", maxLoc);
		// Two arrays are [0, maxLoc], [maxLoc + 1, length-1]. Now binary search in these two arrays
		int searchLoc = Arrays.binarySearch(arr, 0, maxLoc + 1, target);

		// Search in 2nd array if not found in first
		if (searchLoc == -1)
		{
			searchLoc = Arrays.binarySearch(arr, maxLoc + 1, arr.length, target);
		}

		// not found
		return searchLoc > -1 ? searchLoc : -1;
	}

	public static int findPosOfMaxUsingLinearComplexity(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		int maxLoc = -1;

		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
				maxLoc = i;
			}
		}

		return maxLoc;
	}

	public static int findPosOfMaxUsingBinaryComplexity(int[] arr, int start, int end)
	{
		int maxLoc = -1;

		if (start >= end) return -1;

		int mid = (start + end) / 2;

		if(mid > 0)
		{
			if(arr[mid - 1] < arr[mid]) {
				// Skip
			}
			else
			{
				return mid - 1;
			}
		}

		if (mid < end)
		{
			if(arr[mid] < arr[mid + 1])
			{
				// skip
			}
			else
			{
				return mid;
			}
		}

		// Go search in left side:
		int leftSearch = findPosOfMaxUsingBinaryComplexity(arr, start, mid);

		int rightSearch = -1;
		if (leftSearch == -1)
		{
			// Search in right side
			rightSearch = findPosOfMaxUsingBinaryComplexity(arr, mid + 1, end);
		}

		if (leftSearch == -1 && rightSearch == -1) return -1;

		return (leftSearch > rightSearch ? leftSearch : rightSearch);
	}

}
