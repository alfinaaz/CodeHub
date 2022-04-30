class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        
        dp[0]=1;
        dp[1]=1;
        
        int total=0;
        for(int i=2;i<=n;i++)
        {
            total=0;
            for(int j=1;j<=i;j++)
            {
               int l=j-1;
               int r=i-j;
                
            total+=dp[l]*dp[r];     
            
            }
             dp[i]=total;
        }
        return dp[n];
    }
}