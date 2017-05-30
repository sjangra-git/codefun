package codefun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Phone keypad has 2->a,,b,c 3->d,e,f etc mapping. For each given integer number get all the permutations of strings.
public class LettersOfDigits
{
    private static Map<Integer, char[]> intToChar = new HashMap<Integer, char[]>();

    public static void main(String[] args)
    {
        printAllPermutations(234);
    }
    
    private static void printAllPermutations(Integer num)
    {
        // Initialize a map of Integer to List of characters they are mapped to.
        
        intToChar.put(1, new char[]{' '});
        intToChar.put(2, new char[]{'a','b','c'});
        intToChar.put(3, new char[]{'d','e','f'});
        intToChar.put(4, new char[]{'g','h','i'});
        
        // Create integer array out of the number
        int div = num;
        int rem = 0;
        int[] intArray = new int[10];
        int idx=0;
        while(div > 0) 
        {
            rem = div % 10;
            div = div / 10;
            intArray[idx++] = rem;
        }
        
        printLetters(new StringBuilder(), intArray, idx-1);
        
    }
    
    private static void printLetters(StringBuilder sb, int[] array, int pos)
    {
        // If integer array has reached end, just print the string
        if(pos < 0)
        {
            System.out.println(sb.toString());
            return;
        }
        
        char[] letters = intToChar.get(array[pos]);
        for(char ch : letters)
        {
            printLetters(sb.append(ch), array, pos-1);
            sb.deleteCharAt(sb.length()-1);
        }        
    }
}
