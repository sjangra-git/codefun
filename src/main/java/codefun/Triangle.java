package codefun;

import java.util.Arrays;

/**
 * Three segments of lengths A, B, C form a triangle iff
 *
 * A + B > C B + C > A A + C > B
 *
 * e.g. 6, 4, 5 can form a triangle 10, 2, 7 can't
 *
 * Given a list of segments lengths algorithm should find at least one triplet
 * of segments that form a triangle (if any).
 *
 * Method should return an array of either: - 3 elements: segments that form a
 * triangle (i.e. satisfy the condition above) - empty array if there are no
 * such segments
 */

class Triangle {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution2(new int[]{5,2,4,3,1})));
		System.out.println(Arrays.toString(solution1(new int[]{5,1,4,3,2})));
	}

	/**
	 * Sort the array. This ways if a1, a2, a3 don't meet the triangle criteria,
	 * then a1, a2, a4 will definitely not meet the triangle. Because if
	 * a1<a2<a3<a4 and a1+a2 is NOT greater than a3, then definitely a1+a2 will
	 * NOT be greater than a4.
	 **/
	public static int[] solution2(int[] arr) {
		Arrays.sort(arr);

		int i = 0;
		int j = 1;
		for (int k = 2; k < arr.length; k++, i++, j++) {
			if (isTriangle(arr[i], arr[j], arr[k])) {
				return new int[] { arr[i], arr[j], arr[k] };
			}
		}

		return null;
	}

	/**
	 * O(N^3) Tries all possible combinations.
	 **/
	public static int[] solution1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (isTriangle(arr[i], arr[j], arr[k])) {
						return new int[] { arr[i], arr[j], arr[k] };
					}
				}
			}
		}

		return null;
	}

	/**
	 * Criteria for being triangle. A+B>C B+C>A C+A>B
	 **/
	private static boolean isTriangle(int a, int b, int c) {

		if ((a + b > c) && (b + c > a) && (c + a > b)) {
			return true;
		} else {
			return false;
		}
	}
}
