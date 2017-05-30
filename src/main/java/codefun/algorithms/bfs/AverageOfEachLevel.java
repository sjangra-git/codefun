package codefun.algorithms.bfs;

import java.util.*;

/**
 * Average value by level in a tree 
 *
 */
public class AverageOfEachLevel
{

    public static void main(String[] args)
    {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        
        one.left = two;
        one.right = three;
        
        two.left = null;
        two.right = null;
        
        three.left = null;
        three.right = null;
        
        printLevelSum(one);
    }
    
    public static void printLevelSum(Node root)
    {
         Queue<Node> queue = new LinkedList<Node>();
         Node marker = null;
         queue.add(root);
         queue.add(marker);

         float avg = 0;
         int sum = 0;
         int cnt = 0;
         int level=0;

         while(!queue.isEmpty())
         {
              Node curr = queue.remove();

              if(curr == null)
              {
                   avg = (float) sum/cnt;                   
                   cnt = 0;
                   sum = 0;
                   level++;

                   System.out.println("Level="+level + " avg="+ avg);
                   if(queue.size() > 0)
                        queue.add(marker);
                   continue;
              }

              sum = sum + curr.data;
              cnt++;

              if(curr.left != null)
               {
                    queue.add(curr.left);
               }

              if(curr.right != null)
              {
                   queue.add(curr.right);
              }
         }
    }
    
    public static class Node 
    {
        int data;
        Node left;
        Node right;
        Node (int data)
        {
            this.data = data;
        }
    }
}
