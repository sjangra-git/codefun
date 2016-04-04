package codefun;

import java.lang.IllegalArgumentException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInString
{

    public static void main(String[] args)
    {
        try
        {
            System.out.println(method1("geekforgeek"));
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static String method1(String input) throws Exception
    {
        if(input == null) throw new IllegalArgumentException("Input string cannot be null");
        if(input.trim().isEmpty()) return input;
        
        Set<Character> charSet = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++)
        {
            // If this character has already been seen, ignore it
            if(charSet.contains(input.charAt(i)))
            {
                continue;
            }
            else 
            {
                charSet.add(input.charAt(i));
                sb.append(input.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
