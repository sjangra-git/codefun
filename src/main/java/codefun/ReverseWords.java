package codefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseWords
{

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
                if(!line.isEmpty())                                                
                {
                    String[] tokens = line.split("\\s+");
                    Stack<String> wordStack = new Stack<String>();
                    for(String token : tokens)
                    {
                        wordStack.push(token);
                    }
                    
                    StringBuilder sb = new StringBuilder();
                    String space = new String(" ");

                    // Print out the stack
                    while(!wordStack.isEmpty())
                    {
                        sb.append(wordStack.pop());
                        
                        if(!wordStack.isEmpty()) sb.append(space);
                    }                    
                    
                    System.out.println(sb);
                }
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
