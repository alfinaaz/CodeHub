// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public int palindromicPartition(String s){
         
        int[][] mem= new int[2001][2001];
         for (int i = 0; i <= mem.length-1; i++) {
            Arrays.fill(mem[i], -1);
        }
        return solve(0,s.length()-1,s,mem);
    }
    
    public int solve(int i, int j, String s,int[][] mem)
    {
        if( i >= j || isPalindrome(s, i, j) )
            return 0;
        
        int min= Integer.MAX_VALUE;
        if(mem[i][j]!=-1)
            return mem[i][j];
        
        for(int k=i;k<=j-1;k++)
        {
            int temp= solve(i,k,s,mem) +solve(k+1,j,s,mem)+1;
                
            min=Math.min(min,temp);
        }
        
        return mem[i][j]=min;
        
    }
    static boolean isPalindrome(String string, int i, int j)
  {
    while(i < j)
    {
      if(string.charAt(i) != string.charAt(j))
        return false; 
      i++;
      j--;
    }
    return true;
  }
}