//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends






class Solution {
    public int findCatalan(int n) {
        if (n == 0) {
            return 1;
        }      
        final int MOD = (int) (1e9 + 7);
        long[] v = new long[n + 1];
        v[0] = v[1] = 1;
        
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                v[i] = (v[i] + (v[j] * v[i - j - 1]) % MOD) % MOD;
            }
        }  
        return (int) v[n];
    }
}
        