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
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends




class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // Sorting the array to make it easier to find the minimum difference
        Collections.sort(a);

        // Initialize the minimum difference to a large value
        long min = Integer.MAX_VALUE;

        // Sliding window approach to find the minimum difference between elements
        for (int i = 0; i + m - 1 < n; i++) {
            int left = i;
            int right = i + m - 1;
            long diff = a.get(right) - a.get(left);
            min = Math.min(min, diff);
        }

        return min;
    }
}
