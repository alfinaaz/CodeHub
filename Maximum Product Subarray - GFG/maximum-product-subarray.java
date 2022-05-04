// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        
         int flag=0;
        
        if(arr.length==1)
            return arr[0];
        
        long maxEnd=1,minEnd=1;
        long max=Integer.MIN_VALUE;
        
        for(int i=1;i<arr.length;i++)
        {
            
           if(!((arr[i]<0 && arr[i-1]==0)|| (arr[i]==0 && arr[i-1]<0)) || arr[i]==0 && arr[i-1]==0)
           {
               flag=1;
               break;
           }
            
            
        }
        if(flag==0)
            return 0;
        
        
      
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                maxEnd=1;
                minEnd=1;
                continue;
            }
            
            long temp=maxEnd;
            maxEnd=Math.max(Math.max(maxEnd*arr[i],minEnd*arr[i]),arr[i]);
            minEnd=Math.min(Math.min(temp*arr[i],minEnd*arr[i]),arr[i]);
            
            max=Math.max(max,maxEnd);
        }
        
        return max;
    }
}
        
        
        
