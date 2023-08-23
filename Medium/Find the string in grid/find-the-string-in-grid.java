//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends




//User function Template for Java


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        char[] str=word.toCharArray();
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==str[0])
                {
                    // directions
                    boolean found=false;
                    for(int dr=-1;dr<=1;dr++)
                    {
                        for(int dc=-1;dc<=1;dc++)
                        {
                            if(dr==0&&dc==0)continue;
                            found=dfs(i,j,dr,dc,0,str,grid);
                            if(found)
                            {
                                // ans
                                res.add(new int[]{i,j});
                                break;
                            }
                        }
                        if(found)break;
                    }
                }
            }
        }
        int[][] ans=new int[res.size()][2];
        int k=0;
        for(int[] cord:res)
        {
            ans[k][0]=cord[0];
            ans[k][1]=cord[1];
            k++;
        }
        return ans;
    }
    private boolean dfs(int row,int col,int dr,int dc,int ind,char[] word,char[][] grid)
    {
        if(ind==word.length)return true;
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]!=word[ind])return false;
        return dfs(row+dr,col+dc,dr,dc,ind+1,word,grid);
    }
}