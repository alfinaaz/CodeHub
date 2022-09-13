class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
           int n=jobDifficulty.length;
        
        if(d>n){
            return -1;
        }
            int[][] dp= new int[n+1][d+1];
        
           dp[n-1][1]=jobDifficulty[n-1];
            for(int i=n-2;i>=0;i--)
            {
                dp[i][1]= Math.max(dp[i+1][1],jobDifficulty[i]);
            }
        
         for(int drem=2;drem<=d;drem++)
         {
             for(int i=0;i<n-(drem-1);i++)
             {
                dp[i][drem]=Integer.MAX_VALUE;
                int maxdiff=0;
                 for(int j=i+1;j<n-(drem-2);j++)
                 {
                     maxdiff= Math.max(maxdiff,jobDifficulty[j-1]);
                     dp[i][drem]= Math.min(dp[i][drem],maxdiff+dp[j][drem-1]);                }
                 
             }
             
             
         }
        
        return dp[0][d];
    }
}