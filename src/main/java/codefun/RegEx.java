package codefun;

public class RegEx {

	public static void main(String[] args) {
//		if(!match("a.b", "abb")) {
//			System.err.println("ERROR at 1");
//		}
//		
		if(!match("a*b*b", "abbc")) {
			System.err.println("ERROR at 2");
		}
	}
	
	private static boolean match(String regex, String input) {
		boolean match = false;
		
		// Anyone is null
		if(regex == null || input == null) return false;
		
		// Regex or input is empty
		if(regex.isEmpty() || input.isEmpty()) return false;
		
		if(isSpecialChar(regex.charAt(0))) {
			// Check '.'
			if(regex.charAt(0) == '.') {
				match = match(regex.substring(1), input.substring(1));
				return match;
			}
			else if(regex.charAt(0) == '*') {
				String regexSub = regex.substring(1);
				for(int i = 0; i<input.length(); i++) {					
					match = match(regexSub, input.substring(i));
					
					// If match with this sub-string return match
					if(match) {
						return true;
					}
				}
				
				return match;
			}
		} 
		else {
			// Base case
			if(regex.length() == 1 && input.length()==1) {
				if(regex.equals(input)) {
					return true;
				} 
				else {
					return false;
				}
			}
			
			// Otherwise if the first characters match - go down one level
			if(regex.charAt(0) == input.charAt(0)) {
				match = match(regex.substring(1), input.substring(1));
			}
			else {
				return false;
			}
		}
		
		return match;
	}
	
	private static boolean isSpecialChar(char ch) {
		if(ch== '.' || ch=='*' || ch=='+') return true;
		else return false;
				
	}
}
