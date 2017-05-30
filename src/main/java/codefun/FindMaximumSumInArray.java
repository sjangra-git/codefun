package codefun;

/**
 * READ : http://www.ics.uci.edu/~goodrich/teach/cs161/notes/MaxSubarray.pdf
 * for best solution.
 * @author sjangra
 *
 */
public class FindMaximumSumInArray {

	  public static void main(String[] args) {
	  
	    int[] arr = {1, -1, 2, 3, -4, 7, -6, 4, 1, -2};
	    
	    Result res = findMaximumSumInArray(arr);
	    System.out.println(res);
	  }
	  
	  /**
	   * Solution 1:
	   * Starting from 1st element, take sum of each subset of elements 1-2, 1-3, 1-4, 1-5 ...
	   * Then start from 2nd element, take sum of each subset 2-3, 2-4, 2-5...
	   * Keep doing this till last element.
	   * Keep a global sum variable and update its value anytime a bigger subset sum is found.
	   * @param input
	   * @return
	   */
	  public static Result findMaximumSumInArray(int[] input) {
	  
	    Result result = new Result();
	    Integer sum = null;
	    int temp = 0;
	    for(int i = 0; i< input.length; i++) {
	    	temp = input[i];
	    	
	    	for(int j = i+1; j<input.length; j++) {
	    		temp = temp + input[j];
	    		if(sum == null) 
	    			sum = temp;
	    			
	    		if(temp > sum) {
	    			sum = temp;
	    			result.sum = sum;
	    			result.startIndex = i;
	    			result.endIndex = j;
	    		}
	    	}
	    }
	    
	    return result;
	  }
	  
	  
	  static class Result {
	  	int sum;
	  	int startIndex;
	  	int endIndex;
		@Override
		public String toString() {
			return "Result [sum=" + sum + ", startIndex=" + startIndex
					+ ", endIndex=" + endIndex + "]";
		}
	  	
	  	
	  }
	}
