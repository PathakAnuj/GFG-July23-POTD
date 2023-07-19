//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public static int palinSubSeq(String str,int i,int j,int dp[][]){
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        //if(dp[i][j])
        if(str.charAt(i)==str.charAt(j)){
        if(i==j)
        dp[i][j]=1+palinSubSeq(str,i+1,j-1,dp);
        else dp[i][j]=2+palinSubSeq(str,i+1,j-1,dp);
        }
        else 
        dp[i][j]=Math.max(palinSubSeq(str,i+1,j,dp),palinSubSeq(str,i,j-1,dp));
    
        return dp[i][j];
    }
    public int longestPalinSubseq(String S)
    {
        int n=S.length();
        int [][]dp=new int [n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
       return palinSubSeq(S,0,n-1,dp);        //code here
    }
}