package codefun;
/**
 * Find Kth largest element from 2 sorted arrays
 * @author sjangra
 *
 */
public class KthLargestElement {

	public static void main(String[] args) {
		int arr1[] = {1,2,3};
		int arr2[] = {4,5,6};
		
		System.out.println(findKthLargest(arr1, arr2, 6));
	}
	
	private static int findKthLargest(int[] arr1, int[] arr2, int k) {
		int p1=0;
		int p2=0;
		int array = -1;
		
		int cnt = k;
		
		if(k > (arr1.length + arr2.length)) throw new IllegalArgumentException("Invalid k");
		
		while(cnt > 0 && p1 < arr1.length && p2 <arr2.length) {
			if(arr1[p1] <= arr2[p2]) {
				array=0;
				p1++;
				cnt--;
			} else {
				array=1;
				p2++;
				cnt--;
			}
		}
		
		if (p1 == arr1.length && cnt !=0) return arr2[p2+cnt];
		else if (p2 == arr2.length && cnt !=0) return arr1[p1+cnt];
		
		if(cnt == 0 && array == 0) return arr1[p1-1];
		else return arr2[p2-1];
	}
}
