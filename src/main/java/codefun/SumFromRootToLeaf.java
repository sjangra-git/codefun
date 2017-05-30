package codefun;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 * An example is the root-to-leaf path 1->2->3 which represents the number 123.

 * Find the total sum of all root-to-leaf numbers.
 */
public class SumFromRootToLeaf
{

    public static int sum = 0;
    public static void main(String[] args)
    {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
                        
        root.left = two;
        root.right = three;
        
        two.left = four;
        two.right = five;
        
        three.left = six;
        
        
        StringBuilder sb = new StringBuilder();
        preOrderVisit(root, sb);
        System.out.println("Sum: " + sum);
    }
    
    public static void preOrderVisit(Node node, StringBuilder sb)
    {
        if(node == null) return;
        
        // Leaf node
        if(node.left == null && node.right == null)
        {
            int idx = sb.length();
            sb.append(node.val);
            sum += Integer.valueOf(sb.toString());
            
            System.out.println("Number: " + sb.toString());
            // remove the leaf node from string
            sb.deleteCharAt(idx);
            System.out.println("Removed leaf: " + sb.toString());
            return;
        }
        
        int idx = sb.length();
        
        // Append current node
        sb.append(node.val);
        
        preOrderVisit(node.left, sb);
        preOrderVisit(node.right, sb);
        
        if(idx > -1)
        // Remove current node from sb
        sb.deleteCharAt(idx);         
    }
    
    public static class Node 
    {
        int val;
        Node left;
        Node right;
        
        Node(int val)
        {
            this.val = val;
        }
    }
}
