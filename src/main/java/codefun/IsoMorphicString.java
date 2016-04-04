package codefun;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString
{
    public static void main(String[] args)
    {
        System.out.println("false == " +isIsomorphic("foo", "aar"));
        System.out.println("false == " +isIsomorphic("foo", "bar"));
        System.out.println("true == " +isIsomorphic("turtle", "tletur"));
    }

    public static boolean isIsomorphic(String a, String b)
    {
      if(a==null || b==null) return false;

      if(a.length() != b.length()) return false;

      if(a.trim().length() == 0 || b.trim().length() == 0) return false;

      Map<Character, Character> charToCharMap = new HashMap<Character, Character>();
      Map<Character, Character> reverseCharMap = new HashMap<Character, Character>();
      for(int i = 0; i< a.length(); i++)
      {
        // Key already present in the map
        if(charToCharMap.containsKey(a.charAt(i)))
        {
          Character keyMapping = charToCharMap.get(a.charAt(i));
          if(!keyMapping.equals(b.charAt(i))) return false;
        }

        if(reverseCharMap.containsKey(b.charAt(i)))
        {
            Character keyMapping = reverseCharMap.get(b.charAt(i));
            if(!keyMapping.equals(a.charAt(i))) return false;
        }
        
       // else, add to map
       charToCharMap.put(a.charAt(i), b.charAt(i));
       reverseCharMap.put(b.charAt(i), a.charAt(i));
      }

      return true;
    }
}
