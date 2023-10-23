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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends

class Solution
{
    public int maxSumIS(int arr[], int n)  
    {
        int[] msis = new int[n];
        
        // Initialize the msis array with the values of the input array
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (msis[i] > maxSum) {
                maxSum = msis[i];
            }
        }
        
        return maxSum;
    }
}