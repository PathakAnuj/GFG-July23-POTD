//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


// In This question I used Sliding Window Approch.
class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while (j < n-1) {
            if (prices[j + 1] <= prices[j]) {
                sum += prices[j] - prices[i];
                i = j + 1;
                j = j + 1;
            } else {
                j++;
            }
        }
        
        sum += prices[j] - prices[i];
        
        return sum;
    }
}   
