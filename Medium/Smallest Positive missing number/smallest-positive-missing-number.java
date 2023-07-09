//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        
        boolean b[] = new boolean[size+1];
        
        Arrays.fill(b,false);
        b[0] = true;
        
        for(int i=0;i<size;i++){
            
            if(arr[i]>0 && arr[i]<=size){
                //+ve 
                b[arr[i]] = true;
            }
        }
        int i;
        for(i=0;i<size+1;i++){
            
            if(b[i] == false){
                return i;
            }
        }
        
        return i; 
        
        
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends