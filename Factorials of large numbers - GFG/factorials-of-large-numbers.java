// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        
        ArrayList<Integer> res= new ArrayList<>();
        
        res.add(1);
        
        for(int i=2;i<=N;i++)
        {
            int carry=0;
            for(int j= res.size()-1; j>=0;j--)
            {
               int mul=res.get(j)*i+carry;
                carry=mul/10;
                mul=mul%10;
                res.set(j,mul);
                
            }
             while(carry>0){
                   
                   int rem=carry;
                   rem=carry%10;
                   carry=carry/10;
                   res.add(0,rem);    
             }
        }
        return res;
        
    }
}