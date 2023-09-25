//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
         ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
         Arrays.sort(arr);
        
         int n=arr.length;
         for(int i=0;i<n-3;i++)
         {
             for(int j=i+1;j<n-2;j++)
             {
                 int remaining=k-arr[i]-arr[j];
                 int start=j+1;
                 int end=n-1;
                 while(start<end)
                 {
                     int sum=arr[start]+arr[end];
                     if(sum==remaining)
                     {
                          ArrayList<Integer> list1=new ArrayList<>();
                         list1.add(arr[i]);
                         list1.add(arr[j]);
                         list1.add(arr[start]);
                        list1.add(arr[end]);
                         list.add(list1);
                         while(start+1<n && arr[start+1]==arr[start])
                         {
                             start++;
                         }
                         start++;
                                            }
                     else if(sum>remaining)
                     {
                         end--;
                     }
                     else
                     {
                         start++;
                     }
                 }
                  while(j+1<n && arr[j+1]==arr[j]) j++;
             }
             while(i+1<n && arr[i+1]==arr[i]) i++;
         }
         Collections.sort(list,new sorty());
         
         return list;
    }
    class sorty implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a,ArrayList<Integer> b) 
        {
            for(int i=0;i<4;i++)
            {
                if(a.get(i)>b.get(i))
                {
                    return 1;
                }
                else if(b.get(i)>a.get(i))
                {
                    return -1;
                }
            }
            return 1;
        }
    }
   
}