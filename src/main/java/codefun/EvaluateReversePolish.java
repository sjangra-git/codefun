package codefun;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// Question - http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/ 
public class EvaluateReversePolish
{

    public static void main(String[] args)
    {
        char[] input = new char[]{'2','1','+','3','*'};
        
        Integer out = evalReversePolish(input);
        System.out.println(out);
    }
    
    private static Integer evalReversePolish(final char[] input)
    {
        Integer result = null;
        Set<Character> set = new HashSet<Character>();
        set.add('+');
        set.add('-');
        set.add('/');
        set.add('%');
        set.add('*');
        
        int zeroVal = '0';
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<input.length; i++)
        {
            // add to stack
            if(!set.contains(input[i]))
            {
                stack.push(Integer.valueOf(input[i]) - zeroVal);                
            }
            else 
            {
                // found an operator - pop two elements out and do the operation and push back on stack
                int b = stack.pop();
                int a = stack.pop();
                switch(input[i])
                {
                  case '+': stack.push(a + b); break;
                  case '-': stack.push(a - b); break;
                  case '%': stack.push(a % b); break;
                  case '/': stack.push(a / b); break;
                  case '*': stack.push(a * b); break;
                  default: System.err.println("-- ERROR -- : Wrong operation");
                      throw new IllegalArgumentException("Wrong operation requested");
                }
            }
        }
         result = stack.pop();
        return result;
    }
}
