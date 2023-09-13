//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

 class Solution {
    public String findLargest(int N, int S) {
        String temp = "";
        String zero = "0";

        if (S > N * 9) {
            return "-1";
        }

        if (N > 1 && S == 0) {
            return "-1";
        }

        StringBuilder number = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (S > 9) {
                temp = "9";
                number.append(temp);
                S = S - 9;
            } else if (S > 0) {
                int num = S;
                temp = Integer.toString(num);
                number.append(temp);
                S = 0;
            } else {
                number.append(zero);
            }
        }
        return number.toString();
    }
}