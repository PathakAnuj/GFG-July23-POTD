//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //dfs function
    public void dfs(int node, ArrayList<ArrayList<Integer>>adj, boolean[] vis){
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
    
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
        int ans  = -1;
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                dfs(i,adj,vis);
                ans = i;
            }
        }
        
        Arrays.fill(vis, false);
        dfs(ans, adj, vis);
        
        for(int i=0; i<V; i++){
            if(!vis[i]) return -1;
        }
        
        return ans;
    }
}