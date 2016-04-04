package codefun;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibR(4));
		
		for(int i = 1; i < 20; i++) {
			if(fibR(i) != fibI(i)) {
				System.out.println("Unqeual for i="+i);
			} else {
				System.out.println("equal");
			}
		}
	}
	
	// Iterative
	private static int fibI(int n) {
		if(n <1) return -1;		
		int a = 0;
		int b = 1;
		
		if(n == 1) return a;
		if(n==2) return b;
		
		int num = -1;
		for(int i=3; i<n+1; i++) {
			num = a + b;
			a = b;
			b = num;
		}
		
		return num;
	}
	
	// recursive
	private static int fibR(int n) {
		if(n==1) return 0;
		if(n==2) return 1;
		
		int num = fibR(n-1) + fibR(n-2);
		return num;
	}
}
