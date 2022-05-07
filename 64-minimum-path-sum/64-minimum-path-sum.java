class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
       
        int[][] dp= new int[n][m];
        
        dp[n-1][m-1]=grid[n-1][m-1];
        
        for(int i=n-1;i>=0;i--)
        {
            
            for(int j=m-1;j>=0;j--)
            {
                
                if(i<n-1 && j<m-1)
                {
                    dp[i][j] = dp[i+1][j]<=dp[i][j+1]?dp[i+1][j]+grid[i][j]:dp[i][j+1]+grid[i][j];
                    
                }
               else if(i<n-1)
                {
                    dp[i][j] = dp[i+1][j]+grid[i][j];
                   
                }
               else  if(j<m-1)
                {
                     
                    dp[i][j] = dp[i][j+1]+grid[i][j];
                    
                  
                }
                
            }
            
        }
        
        return dp[0][0];
     
    }  
}