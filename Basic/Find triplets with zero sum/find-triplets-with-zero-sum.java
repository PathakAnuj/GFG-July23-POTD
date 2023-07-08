//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


class Solution {
    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public boolean findTriplets(int arr[], int n) {
        // Sorting the array in ascending order
        Arrays.sort(arr);
        
        // Fixing the first element and finding the other two elements
        for (int i = 0; i < n - 2; i++) {
            // Two-pointer approach to find the other two elements
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == 0) {
                    // Triplet with zero sum found
                    return true;
                } else if (sum < 0) {
                    // If the sum is smaller than zero, increment the left pointer
                    left++;
                } else {
                    // If the sum is greater than zero, decrement the right pointer
                    right--;
                }
            }
        }
        
        // No triplet with zero sum found
        return false;
    }
}
