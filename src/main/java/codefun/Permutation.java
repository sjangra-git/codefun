package codefun;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3 };
		int[] permutation = new int[arr.length];

		System.out.println("Start");
		permute(arr, permutation, 0);
	}

	/**
	 * Algo:
	 * 
	 *  At each level of the recursion, keeping the array of available integers in 'arr'.
	 *  At every level we consume one element from 'arr' (always start from the beginning of the array, till end)
	 *  So at the lower level we decrement the array size by one.
	 *  
	 *  Also, we carry the permutation array at each level. When we reach the leaf level i.e no more elements in 'arr'
	 *  then we print the permutation array. Also to keep track of the position where we need to write in permutation array 
	 *  we keep track of a 'writeIndex'. Its value increases by one as we go deeper.
	 */
	public static void permute(int[] arr, int[] permutation,
			int writeIndex) {

		// base condition
		if (arr.length == 0) {
			// print the current permutation
			System.out.println(Arrays.toString(permutation));
			return;
		}

		// Go over each element in the remaining array
		for (int i = 0; i < arr.length; i++) {

			// put the current value in the permutation 
			permutation[writeIndex] = arr[i];
			
			// Caculate the remaining array
			int[] remainingArr = new int[arr.length-1];
			int index = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					remainingArr[index++] = arr[j];
				}
			}
			permute(remainingArr, permutation, writeIndex+1);
		}

	}
}