//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends




//User function Template for Java
class Solution {
 
public int[] shortestPath(int N,int M, int[][] edges) {
//Code here
int dist[] = new int[N];
Arrays.fill(dist,Integer.MAX_VALUE);
dist[0]=0;
 
for(int i=0;i<M-1;i++)
{
    for(int [] val:edges)
    {
        int src=val[0];
        int dest=val[1];
        int w = val[2];
        
        if(dist[src]!=Integer.MAX_VALUE && dist[src]+w<dist[dest])
        {
            dist[dest]=dist[src]+w;
        }
    }
}
 
for(int i=0;i<N;i++)
{
    if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
}
 
return dist;
 
}
}