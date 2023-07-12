//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends



class Solution {
    long power(int N, int R) {
        long MOD = 1000000007;
        
        // Initialize the result to 1
        long result = 1;
        
        // Iterate until the reverse becomes zero
        while (R > 0) {
            // If the current reverse is odd, multiply the result by N and take the modulo
            if (R % 2 == 1) {
                result = (result * N) % MOD;
            }
            
            // Reduce the reverse by dividing it by 2
            R /= 2;
            
            // Square the base N and take the modulo
            N = (int)(((long)N * N) % MOD);
        }
        
        return result;
    }
}
