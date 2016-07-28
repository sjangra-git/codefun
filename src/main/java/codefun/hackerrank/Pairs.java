package codefun.hackerrank;

import java.util.*;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/pairs
public class Pairs {


  public static void main(String[] args) 
  {
	  Scanner scanner = new Scanner(System.in);
	  int N = scanner.nextInt();
	  int K = scanner.nextInt();
	  
	  int[] a = new int[N];
	  for(int i = 0; i<N; i++)
	  {
		  a[i] = scanner.nextInt();
	  }
	  
	  System.out.println(bruteForce(N, K, a));
  }
  
  public static int bruteForce(int N, int K, int[] a)
  {
	  int count = 0;
	  
    	  Arrays.sort(a);

	  for(int i = 0; i<N-1; i++)
	  {
		  for (int j = i+1; j<N; j++)
		  {
              
			  if(Double.compare(K, Math.abs(a[i] - a[j])) == 0)
			  {
				  count++;
                  break;
			  }
              else if(Double.compare(K, Math.abs(a[i] - a[j])) < 0) {
                  break;
              }
		  }
	  }
	  
	  return count;
  }
}