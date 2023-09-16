//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long mod = 1000000007;
    static long countWays(int n)
    {
        // add your code here
        // long[] dp = new long[n+1];
        // Arrays.fill(dp, -1);
        // return memoization(n, dp);
        if(n<=2){
            return (long)n;
        }
        return SpaceOptimized(n);
    }
    
    static long memoization(int idx, long[] dp) {
        if(idx<=1){
            return 1;
        }
        
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        long first = 0, second = 0, third = 0;
        if(idx>=1){
            first = memoization(idx-1, dp);
        }
        if(idx>=2){
            second = memoization(idx-2, dp);
        }
        if(idx>=3){
            third = memoization(idx-3, dp);
        }
        
        return dp[idx]=(first+second+third)%mod;
    }
    
    static long Tabulation(int N) {
        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        
        for(int idx=3; idx<N; idx++){
            dp[idx] = (dp[idx-1]+dp[idx-2]+dp[idx-3])%mod;
        }
        
        return (dp[N-1])%mod;
    }
    
    static long SpaceOptimized(int N) {
        long prev3 = 1;
        long prev2 = 2;
        long prev1 = 4;
        
        for(int idx=3; idx<N; idx++){
            long prev = (prev1 + prev2 + prev3)%mod;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = prev;
        }
        
        return prev1;
    }
    
}


