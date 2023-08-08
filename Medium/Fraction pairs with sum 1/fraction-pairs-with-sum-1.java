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
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int countFractions(int n, int[] nu, int[] d) {
        int ans =0;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = nu[i];
            int y = d[i];
            if(x>y)
                continue;
            int z = gcd(x,y);
            x/=z;
            y/=z;
            if(map.containsKey(y)){
                map.get(y).add(x);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y,list);
            }
        }
        for(Map.Entry<Integer,List<Integer>> x:map.entrySet()){
            int sum = x.getKey();
            List<Integer> list = x.getValue();
            if(list.size()==1)
                continue;
            HashMap<Integer,Integer> m = new HashMap<>();
            for(int f : list){
                m.put(f,m.getOrDefault(f,0)+1);
            }
            for(Map.Entry<Integer,Integer> y : m.entrySet()){
                if(sum-y.getKey()==y.getKey()){
                    int h = y.getValue(); 
                    ans += (h*(h-1));
                }else if(m.containsKey(sum-y.getKey()))
                    ans+=(y.getValue()*m.get(sum-y.getKey()));
            }
        }
        return ans/2;
    }
    static int gcd(int a, int b)
    {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }
}     
