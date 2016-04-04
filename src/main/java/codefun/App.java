package codefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void getFirstUniqueChar(String input)
    {
        if(input == null || input.trim().isEmpty())
        {
            System.out.println("");
            return;
        }
        
        // Store character to integer in a listmap
        LinkedHashMap<Character, Integer> listMap = new LinkedHashMap<Character, Integer>();
        for(char ch : input.toCharArray())
        {
            int count = 0;
            if(listMap.containsKey(ch))
            {
                count = listMap.get(ch);
            }
            
            count++;
            listMap.put(ch, count);
        }
        
        // Since listMap is also a list so there is an order of characters
        for(Map.Entry<Character, Integer> entry : listMap.entrySet())
        {
            if(entry.getValue() == 1)
            {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        Scanner sc = null;
        try
        {
            sc = new Scanner(file);            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                getFirstUniqueChar(line);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            sc.close();
        }
        
    }

    
    

}
