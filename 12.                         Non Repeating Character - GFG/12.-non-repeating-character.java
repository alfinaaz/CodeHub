// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static int CHAR=256;
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int res=Integer.MAX_VALUE;
        int[] count= new int[CHAR];
        Arrays.fill(count,-1);
        for(int i=0;i<S.length();i++)
        {
            if(count[S.charAt(i)]==-1)
                count[S.charAt(i)]=i;
            else
                count[S.charAt(i)]=-2;
        }
        for(int i=0;i<CHAR;i++)
        {
            if(count[i]>=0)
                res=Math.min(res,count[i]);
                
        }
        return (res==Integer.MAX_VALUE)?'$':S.charAt(res);
    
        }        
    
}


