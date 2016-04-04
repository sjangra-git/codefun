package codefun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class Solution1 {
    
    public static void main(String[] args)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = null;
        
        System.out.println(isPalindrome(n1));
    }
    
    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        // count length;
        ListNode curr = head;
        int length=0;
        while(curr != null)
        {
            length++;
            curr = curr.next;
        }
        
        if(length ==1) return true;
        
        // count hashes
        long h1 = 0;
        // reverse hash
        long h2 = 0;
        
        curr = head;
        int i= 0;
        while(curr != null)
        {            
            h1 += curr.val * Math.pow(10, i);
            h2 += curr.val * Math.pow(10, length - i - 1);
            i++;
            curr = curr.next;
        }
        
        if(h1 == h2) return true;
        else return false;
    }
    
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}