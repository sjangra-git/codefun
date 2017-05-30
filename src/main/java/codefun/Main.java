package codefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main
{

     public static void main(String[] args)
     {
          File file = new File(args[0]);
          Scanner in = null;
          try
          {
            in = new Scanner(file);
               while(in.hasNextLine())
               {
                    String line = in.nextLine();
                    String[] tokens = line.split(",");
                    Set<Character> scrubSet = new HashSet<Character>();
                    
                    for(char ch : tokens[1].trim().toCharArray())
                    {
                        scrubSet.add(ch);
                    }

                    for(char ch : tokens[0].toCharArray())
                    {
                         if(!scrubSet.contains(ch))
                              System.out.print(ch);
                    }

                    System.out.println();
               }
          }
          catch(FileNotFoundException e)
          {
               e.printStackTrace();
          }
          finally
          {
               if(in != null)
                    in.close();
          }
     }
}