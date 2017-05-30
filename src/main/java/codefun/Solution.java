package codefun;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    

 public static void main(String[] args)
 {
     List<Integer> list = new ArrayList<Integer>();
     list.add(1);
     list.add(2);
     list.add(2);
     list.add(3);
     list.add(1);
     System.out.println(singleNumber(list));
 }
    
    
   

     // DO NOT MODIFY THE LIST
     public static int singleNumber(final List<Integer> a) {
         int res = a.get(0);
         
         for(int i = 1; i<a.size(); i++)
         {
             res = res ^ a.get(i);
         }
         
         return res;
     }

    

}