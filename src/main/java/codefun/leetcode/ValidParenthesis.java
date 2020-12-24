package codefun.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {

		if(!isValid("()"))
			System.out.println("Error 1");

		if(!isValid("[()]"))
			System.out.println("Error 2");

		if(isValid("(]"))
			System.out.println("Error 3");

		if(isValid("([)]"))
			System.out.println("Error 4");

		if(!isValid("()[]{}"))
			System.out.println("Error 5");

		if(isValid("]["))
			System.out.println("Error 6");

	}

	public static boolean isValid(String s)
	{
		boolean isValid = true;

		Map<Character, Integer> charToInt = new HashMap<Character, Integer>();
		charToInt.put('(', 1);
		charToInt.put(')', -1);
		charToInt.put('[', 2);
		charToInt.put(']', -2);
		charToInt.put('{', 3);
		charToInt.put('}', -3);

		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i<s.length(); i++)
		{
			int currentVal = charToInt.get(s.charAt(i));
			// If opening && assume it is a valid string
			if(currentVal > 0)
			{
				stack.push(s.charAt(i));
			}

			// if closing bracket
			if(currentVal < 0)
			{
				if(stack.isEmpty())
				{
					isValid = false;
					break;
				}

				int popped = charToInt.get(stack.pop());

				if (Math.abs(currentVal) != popped)
				{
					isValid = false;
					break;
				}
			}
		}

		if (!stack.isEmpty()) isValid = false;

		return isValid;
	}



}
