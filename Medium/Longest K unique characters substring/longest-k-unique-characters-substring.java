//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int l=0,r=0,ans=-1;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        while(r<s.length()){
            
            if(hm.size()<=k){
                char c= s.charAt(r);
                hm.put(c, hm.getOrDefault(c,0)+1);
                r++;
            }
             
            while(hm.size()>k){ 
                
                char c= s.charAt(l);
                if(hm.get(c)>1) hm.put(c, hm.getOrDefault(c,0)-1);
                else hm.remove(c);
                l++;
            }
            ans= Math.max(ans,r-l);
        }
        
        if(hm.size()<k) return -1;
        return ans;
    }
}