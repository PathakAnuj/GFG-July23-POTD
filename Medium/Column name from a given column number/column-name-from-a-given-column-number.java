//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends



//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
           String str = "";
        
        while(n > 0){
            long r = n % 26;
            if(r == 0){
                n = n - 26;
                r = 26;
            }
            str = (char)(r + 64) + str;
            n = n / 26;
        }
        
        return str;
    }
}