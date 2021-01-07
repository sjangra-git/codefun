package codefun.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = Integer.MIN_VALUE;
		int rev = reverse(x);
		System.out.println(rev + " original: " + x);
	}

	public static int reverse(int x) {
		int revInt = 0;

		// Lesson: Math.abs of Integer.MIN is also negative. Because it exceeds 32 bit range. 
		if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return 0;

		// Get absolute value
		long absInt = Math.abs(x);
		if (x == Integer.MIN_VALUE)
			absInt = x * -1;

		long revLong = 0l;
		long q = absInt;
		int rem = 0;

		while (q != 0)
		{
			rem = (int) q % 10;
			q = q / 10;
			revLong = revLong * 10 + rem;
		}

		// Check for negative sign
		if(absInt > x)
		{
			revLong = revLong * -1;

			if(revLong < Integer.MIN_VALUE)
			{
				revInt = 0;
			}
			else
			{
				revInt = (int) revLong;
			}
		}
		else
		{
			if(revLong > Integer.MAX_VALUE)
			{
				revInt = 0;
			}
			else
			{
				revInt = (int) revLong;
			}
		}

		return revInt;
	}
}
