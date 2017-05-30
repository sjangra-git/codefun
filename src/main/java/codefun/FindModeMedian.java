package codefun;

import java.util.Arrays;

public class FindModeMedian {

	public static void main(String[] args) {
	
//		int[] input = {1,2,3};
//		System.out.println(findMode(input));
		
		int[] input = {1,2,2,2,2,3,3,3,3,3};
		System.out.println(Arrays.toString(findMode(input)));
	}
	
	private static Integer[] findMode(int[] input) {
		Integer mode = null;
		int maxCount = 0;
		
		// Sort the array
		Arrays.sort(input);
		
		int prev = input[0];
		int count = 0;
		for(int i=1; i<input.length; i++) {
			if(input[i] == prev) {
				if(count == 0) count = 2;
				else count++;
			} else {
				if(count >0 && count > maxCount) {
					maxCount = count;
					mode = prev;
					count = 0;
				}
			}						
			
			// save previous
			prev = input[i];
		}
		
		if(count >0 && count > maxCount) {
			maxCount = count;
			mode = prev;
			count = 0;
		}
		
		Integer[] ret = {mode, maxCount};
		return  ret;
	}
}
