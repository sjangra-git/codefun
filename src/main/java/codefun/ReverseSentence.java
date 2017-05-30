package codefun;

import java.util.Stack;

public class ReverseSentence {

	public static void main(String[] args) {
		String input = "Hello how are you?";
		System.out.println(input);
		System.out.println(reverse(input));
	}
	
	private static String reverse(String input) {
		if(input == null) throw new IllegalArgumentException("input is null");
		
		if(input.trim().length() == 0) return input;
		
		String[] array = input.split("\\s+");
		Stack<String> stack = new Stack<String>();
		for(String str : array) {
			stack.push(str);
		}
		
		StringBuilder sb = new StringBuilder(10);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");			
		}
		
		// Delete the last space
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();		
	}
}
