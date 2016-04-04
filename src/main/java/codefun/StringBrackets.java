package codefun;

/**
 * Parse and check if the brackets are good in a string eg.
 * () good
 * ([]) good
 * )( bad etc
 * @author sjangra
 *
 */
public class StringBrackets {

	public static void main(String[] args) {
		
		assert verify("{}") == true; System.out.println(verify("{}"));
		assert verify("()(") == true; System.out.println(verify(")("));
		
	}
	
	public static boolean verify(final String input) {
		boolean returnVal = true;
		int round = 0;
		int square = 0;
		int curly = 0;

		if(input == null) return false;		
		if(input.trim().length() == 0) return true;
		
		for(char ch : input.toCharArray()) {
			switch(ch) {
			case '(': round++; break;
			case '[': square++; break;
			case '{': curly++; break;
			
			case ')': if(round==0) return false;
						round--; break;
						
			case '}': if(curly==0) return false;
						curly--; break;
						
			case ']': if(square==0) return false;
						square--; break;
			
			default: 
			}
		}
		
		if(round != 0 || square != 0 || curly != 0) return false;
		
		return true;
	}
}
