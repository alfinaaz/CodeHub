// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
   public  int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] mem= new int[101][101];
       return matrixMultiplication(arr, 1,N-1,mem);
        
    }
    
    
    public  int  matrixMultiplication(int arr[],int i, int j,int[][] mem)
    {
        
        
        
        if(i>=j)
            return 0;
          
          
          if(mem[i][j]!=0)
                return mem[i][j];
            
         int min=Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++)
        {
           int temp=  matrixMultiplication(arr,i,k,mem)
             +
             matrixMultiplication(arr,k+1,j,mem)
             +
             arr[i-1]*arr[k]*arr[j];
             
             
             min= Math.min(temp,min);
            
            
        }
        
        return mem[i][j]= min;
        
    }
}