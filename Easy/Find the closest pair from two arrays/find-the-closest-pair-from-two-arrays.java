//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends



class Solution{
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        int abs = Integer.MAX_VALUE;
        Arrays.sort(brr);
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
        	if(arr[i] >= x) {
        		if (arr[i] + brr[0] - x < abs) {
        		    list.clear();
        			list.add(arr[i]);
        			list.add(brr[0]);
        		}
        		break;
        	}

        	int req = x - arr[i];
        	int ind = getIndex(brr, req);
            
            
            
        	if(ind >= 0 && brr[ind] == req) {
        		list.clear();
        		list.add(arr[i]);
        		list.add(brr[ind]);
        		break;
        	}

        	int abs1 = ind != -1 ? x - (arr[i] + brr[ind]) : Integer.MAX_VALUE;
        	int abs2 = ind + 1 < m ? (arr[i] + brr[ind + 1]) - x : Integer.MAX_VALUE;

            
        	if(abs1 < abs) {
        		abs = abs1;
        		list.clear();
        		list.add(arr[i]);
        		list.add(brr[ind]);
        	}

        	if(abs2 < abs) {
        		abs = abs2;
        		list.clear();
        		list.add(arr[i]);
        		list.add(brr[ind + 1]);
        	}

        }
        
        return list;
    }

    static int getIndex(int[] arr, int req) {
    	int ind = -1;
    	int l = 0, h = arr.length - 1;

    	while(l <= h) {
    		int mid = (l + h) >> 1;

    		if(arr[mid] <= req) {
    			ind = mid;
    			l = mid + 1;
    		}
    		else {
    			h = mid - 1;
    		}

    	}

    	return ind;
    }
}