// { Driver Code Starts
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
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends



class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        
        int leastsofar=price[0],mpist=0,maxat=price[n-1],mpibt=0;
        int[] dpl= new int[n];
        int[] dpr= new int[n];
        
        for(int i=1;i<n;i++)
        {
            leastsofar=Math.min(leastsofar,price[i]);
            mpist=price[i]-leastsofar;
            
            dpl[i]=Math.max(dpl[i-1],mpist);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            maxat=Math.max(maxat,price[i]);
            mpibt=maxat-price[i];
            
            dpr[i]=Math.max(dpr[i+1],mpibt);
            
            
        }
        int op=0;
        for(int i=0;i<n;i++)
        {
            
            op=Math.max((dpl[i]+dpr[i]),op);
        }
        
        return op;
    }
}
        
