package codefun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Given a linked list, where each node's value can itself be a linked list (a recursive linked list), write a function that flattens it. 
public class FlattenRecursiveLinkedList
{

    private static List<Integer> finalList = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
     
        // example 2-d list
        List<List<Integer>> list2d = new ArrayList<List<Integer>>(4);

        for(int i=0; i<4; i++)
        {
            list2d.add(new ArrayList<Integer>());
        }
        list2d.get(0).add(1);
        list2d.get(0).add(2);
        list2d.get(0).add(3);
        
        list2d.get(1).add(4);
        list2d.get(1).add(5);
        
        list2d.get(2).add(6);
        
        list2d.get(3).add(7);
        list2d.get(3).add(8);
        list2d.get(3).add(9);
        
        flattenList(list2d);
        
        System.out.println(Arrays.toString(list2d.toArray()));
        System.out.println(Arrays.toString(finalList.toArray()));
    }
    
    public static void flattenList(List<?> list)
    {
        Iterator<?> itr = list.iterator();
        while(itr.hasNext())
        {
            Object obj = itr.next();
            // leaf element
            if(obj instanceof Integer)
            {
                finalList.add((Integer) obj);
            }
            else 
            {
                // Non-leaf element
                flattenList((List<?>) obj);
            }
        }
    }
}
