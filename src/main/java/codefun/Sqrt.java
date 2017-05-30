package codefun;

public class Sqrt {

	public static void main(String[] args) {
		System.out.println(sqrt(0, 4, 9));
	}

	/**
	 *	If m is sqrt of N then m*m = N.
	 *	But if m*m>N, then square root of N lies between {1,m-1}. Search left
	 *  If m*m < N, then square root of N lies between {m+1, N}. Search right.
	 *  Keep going left and right until the absolute diff between m*m and N is very less.  
	 * @return
	 */
	private static double sqrt(double left, double right, double num) {
		double m = (left + right) / 2;

		if (Math.abs(m * m - num) < 0.000001)
			return m;

		if (m * m > num) {
			// Go left
			return sqrt(left, m - 1, num);
		} else {
			// Go right
			return sqrt(m + 1, right, num);
		}
	}
}