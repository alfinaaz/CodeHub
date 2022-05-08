// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
     ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        // code here
    
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        dfs(0,res,new ArrayList<String>(),s);
        return res;
        
    }
    
    void dfs(int start,ArrayList<ArrayList<String>> res, ArrayList<String> curr, String s ){
    
    
    if(start>=s.length())
    {
        res.add(new ArrayList<String>(curr));
        return ;
    }
    
    for(int i=start;i<s.length();i++)
    {
        if(isPalindrome(s,start,i))
        {
            curr.add(s.substring(start,i+1));
            dfs(i+1,res,curr,s);
            curr.remove(curr.size()-1);
        }
    }
}
     boolean isPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}