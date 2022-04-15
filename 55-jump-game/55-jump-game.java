class Solution {
    public boolean canJump(int[] arr) {
        
        int n=arr.length;
        int[] dp= new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]!=Integer.MAX_VALUE && i<=(j+arr[j]))
                {
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
                
            }
            
            
        }
        
        if(dp[n-1]==Integer.MAX_VALUE)
                return false;
        
        return true;
        
        
        
    }
}