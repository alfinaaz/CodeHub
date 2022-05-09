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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   static int MOD = 1003;
    static int countWays(int N, String A){
        // code here
     StringBuilder symbols = new StringBuilder();
        StringBuilder operators = new StringBuilder();
        for(int i=0; i <A.length(); ++i) {
            char cur = A.charAt(i);
            if(cur=='T' || cur=='F') symbols.append(cur);
            else operators.append(cur);
        }
        
        
        return cnt(symbols.toString().toCharArray(), operators.toString().toCharArray()) % MOD;
    }
    static int cnt(char exp[] , char op[]) {
        int n= exp.length;
        int t[][] = new int[n][n];
        int f[][]= new int[n][n];
        for(int i=0 ; i < n; ++i) {
            if(exp[i]=='T') t[i][i] = 1;
            else f[i][i] =1;
        }
        for(int gap=1; gap <n; ++gap) {
            for(int i=0, j=gap; j < n; ++i, ++j) {
                
                for(int g=0; g< gap; ++g) {
                    int k = i +g;
                    switch(op[k]) {
                    case '&' : 
                        t[i][j] += t[i][k] * t[k+1][j];
                        f[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                        break;
                    case '|':
                        t[i][j] += t[i][k] * t[k+1][j] + t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j]; 
                        f[i][j] +=  f[i][k] * f[k+1][j];
                        break;
                    case '^':
                        t[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j];
                        f[i][j] += t[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                        break;
                    }
                    
                    t[i][j] %= MOD;
                    f[i][j] %= MOD;
                }
            }
        }
        
        return t[0][n-1];
    }
}
