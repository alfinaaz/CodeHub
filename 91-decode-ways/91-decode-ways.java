class Solution {
    public int numDecodings(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        int n =s.length();
        
        int[] dp= new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        
        for(int i=2;i<=n;i++)
        {
            int x= Integer.parseInt(s.substring(i-1,i));
            int y= Integer.parseInt(s.substring(i-2,i));
            
            if(x>=1 && x <=9)
                dp[i] =dp[i-1];
            
            
            if(y>=10 && y<=26)
                dp[i] +=dp[i-2];
            
            
        }
        
        return dp[n];
    }
}