//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends



class Solution
{
    /*You are required to complete this method*/
  public static int findK(int[][] matrix, int n, int m, int k) {
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int direction = 0; // 0 - left to right, 1 - top to bottom, 2 - right to left, 3 - bottom to top
        
        while (top <= bottom && left <= right) {
            if (direction == 0) { // Traverse left to right
                for (int i = left; i <= right; i++) {
                    if (--k == 0) {
                        return matrix[top][i];
                    }
                }
                top++;
                direction = 1;
            } else if (direction == 1) { // Traverse top to bottom
                for (int i = top; i <= bottom; i++) {
                    if (--k == 0) {
                        return matrix[i][right];
                    }
                }
                right--;
                direction = 2;
            } else if (direction == 2) { // Traverse right to left
                for (int i = right; i >= left; i--) {
                    if (--k == 0) {
                        return matrix[bottom][i];
                    }
                }
                bottom--;
                direction = 3;
            } else if (direction == 3) { // Traverse bottom to top
                for (int i = bottom; i >= top; i--) {
                    if (--k == 0) {
                        return matrix[i][left];
                    }
                }
                left++;
                direction = 0;
            }
        }
        
        return -1; // If k is out of range
    }
}