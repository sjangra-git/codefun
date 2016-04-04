package codefun;

// https://leetcode.com/problems/add-binary/ 
public class AddBinary
{

    public static void main(String[] args)
    {
        
    }
    
    private static String addBinary(String a, String b)
    {
        String res = new String();
        
        if(a.length() > b.length())
        {
            int diff = a.length() - b.length();
            char[] newarr = new char[a.length()];
            
            for(int i = 0; i<diff; i++)
            {
                newarr[i] = '0';
            }
            System.arraycopy(b.toCharArray(), 0, newarr, diff, b.length());
            b = String.valueOf(newarr);
        }
        else if(a.length() < b.length())
        {
            int diff = b.length() - a.length();
            char[] newarr = new char[b.length()];
            
            for(int i = 0; i<diff; i++)
            {
                newarr[i] = '0';
            }
            System.arraycopy(a.toCharArray(), 0, newarr, diff, a.length());
            a = String.valueOf(newarr);
        }
        
        char[] output = new char[a.length()];
        boolean carry = false;
        for(int i = a.length()-1; i > -1; i++)
        {            
            if(a.charAt(i) == 1 && b.charAt(i) == 1)
            {
                carry = true;
                output[i] = '0';
            }
            else if(a.charAt(i) == 1 || b.charAt(i) == 1)
            {
                output[i] = '1';
            }
            else 
            {
                output[i] = '0';
            }
        }
        
        return res;
    }
}
