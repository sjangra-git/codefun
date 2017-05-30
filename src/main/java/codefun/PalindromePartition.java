package codefun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PalindromePartition
{

    static List<List<String>> listOfPalindromes = new ArrayList<List<String>>();
    static Stack<String> stack = new Stack<String>();
    
    public static void main(String[] args)
    {
        findPalindromes("foof", 0, "aab".length());
        System.out.println(listOfPalindromes);
    }
    
    private static void findPalindromes(String input, int start, int end)
    {
        if(start >= end)
        {
            // dump the results
            List<String> list = new ArrayList<String>();
            Iterator<String> itr = stack.iterator();
            while(itr.hasNext())
            {
                list.add(itr.next());                
            }
            
            listOfPalindromes.add(list);
            return;
        }
        
        for(int i = start + 1; i<=end; i++)
        {
            String substring = input.substring(start, i);
            if(isPalindrome(substring))
            {
                stack.push(substring);
                findPalindromes(input, i, end);
                stack.pop();
            }
        }
    }
    
    private static boolean isPalindrome(String input)
    {
        if(input == null || input.length() ==0) return true;
        int length = input.length();
        for(int i = 0; i<input.length(); i++)
        {
            if(input.charAt(i) != input.charAt(length - i - 1)) return false;
        }
        return true;
    }
}
