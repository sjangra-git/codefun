package codefun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 */
public class WordLadder
{

    static Set<String> dict;
    static List<Set<String>> paths = new ArrayList<Set<String>>();
    
    static 
    {
        dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");        
    }
    
    public static void main(String[] args)
    {
        findShortestPath("hit", "cog");
    }
    
    private static List<String> findShortestPath(String start, String end)
    {
        List<String> list = new ArrayList<String>();
        
        findPath(start, end, new LinkedHashSet<String>());
        for(Set<String> set1 : paths)
        {
            for(String str : set1)
            {
                System.out.print(str);
                System.out.print(">>>");
            }
            System.out.println("------------");
        }
        return list;
    }
    
    private static void findPath(final String start, final String end, LinkedHashSet<String> path)
    {
        if(start.equals(end)) 
        {
            path.add(end);
            LinkedHashSet<String> newSet = new LinkedHashSet<String>();
            newSet.addAll(path);
            paths.add(newSet);
            System.out.println("Found: " + Arrays.toString(newSet.toArray()));
            return;
        }
        
        char[] array = start.toCharArray();
        for(int i = 0; i<array.length; i++)
        {
            char oldChar = array[i];
            for(char ch = 'a'; ch<='z'; ch++)
            {
                array[i] = ch;
                
                String newString = String.valueOf(array);
                if(newString.equals(end)) 
                {
                    // found the end string
//                    System.out.print("-->cog ++");
//                    path.add(end);
                    LinkedHashSet<String> newSet = new LinkedHashSet<String>();
                    newSet.addAll(path);
                    paths.add(newSet);
//                    System.out.println("Found: " + Arrays.toString(newSet.toArray()));
                    return;
                }
                
                // end string not found yet - see if string exists in dictionary. If not continue
                if(!dict.contains(newString))
                {
                    continue;
                }
                else 
                {
                    // String exists in the dictionary - but has it been seen before
                    if(path.contains(newString))
                    {
                        continue;
                    }
                    else 
                    {
                        // String has not been seen in the path yet
                        path.add(newString);
//                        System.out.print("-->"+ newString);
                        findPath(newString, end, path);
                        path.remove(newString);
                    }
                }
                                
            }
            array[i] = oldChar;
            //System.out.println(array);
        }
    }
}
