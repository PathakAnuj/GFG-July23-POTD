//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends




//User function Template for Java


class Solution
{public static ArrayList<String> res;
    public void slv(String S,String s)
{
     if(S.equals(""))
     {
         res.add(s);
     }
     for(int i=0;i<S.length();i++)
     {
        slv(S.substring(0,i)+S.substring(i+1),s+S.charAt(i));
     }
}
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        
      res = new ArrayList<>();
        slv(S,"");
        Collections.sort(res);
        return res;
    }
	   
}
