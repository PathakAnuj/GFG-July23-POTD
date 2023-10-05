//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends



class Solution
{
    long helper(String S, int k){
        long ans = 0;
        int left = 0, right = 0;
        int n = S.length();
        int[] chars = new int[26];
        int count = 0;
        // HashMap<Character, Integer> hmap = new HashMap<>();
        
        while(right < n){
            char c = S.charAt(right);
            chars[c - 'a'] += 1;
            
            if(chars[c - 'a'] == 1) count += 1;
            
            while(count > k){
                char d = S.charAt(left);
                chars[d - 'a'] -= 1;
                
                if(chars[d - 'a'] == 0) count -= 1;
                left += 1;
            }
            
            ans += (right - left + 1);
            right += 1;
        }
        
        return ans;
    }
    long substrCount (String S, int K) {
        // your code here
        long high = helper(S, K);
        long low = helper(S, K-1);
        // System.out.println(high + " " + low);
        return high - low;
    }
}