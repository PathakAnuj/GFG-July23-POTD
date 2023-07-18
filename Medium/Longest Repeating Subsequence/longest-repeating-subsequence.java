//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
     public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int[][] dp=new int[str.length()][str.length()];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        return f(str,0,0,sb.toString(),dp);
    }
    int f(String str,int i,int j,String str1,int[][] dp){
        if(i>=str.length() || j>=str1.length()){
            return 0;
        }  
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }
       else if(str.charAt(i)==str1.charAt(j) && i!=j ){
            return 1+f(str,i+1,j+1,str1,dp);
        }
        else
            return dp[i][j]= Math.max(f(str,i,j+1,str1,dp),f(str,i+1,j,str1,dp));
        
        
    }
}