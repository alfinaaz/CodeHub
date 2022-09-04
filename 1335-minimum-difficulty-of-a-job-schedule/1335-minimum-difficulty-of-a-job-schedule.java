class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n=jobDifficulty.length;
        
        //Edge Case :
        if(n<d)
        {
            return -1;
        }
        
        int[][] mem= new int[n][d+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=d;j++)
            {
                mem[i][j]=-1;
            }
        }
        
        return minDiff(0,n,d,jobDifficulty,mem);
        
        
        
    }
    
    public int minDiff(int i,int n,int d,int[] jobDifficulty,int[][] mem)
    {
        
        
        if (mem[i][d] != -1) 
            return mem[i][d];
        
        if(d==1)
        {
            int maxDiff=0;
            for(int j=i;j<n;j++)
            {
                maxDiff= Math.max(maxDiff,jobDifficulty[j]);
            }
            
            return maxDiff;
        }
        int res=Integer.MAX_VALUE;
        int dailyMaxJobDiff=0;
        for(int j=i;j<n-(d-1);j++)
        {
            dailyMaxJobDiff=Math.max(dailyMaxJobDiff,jobDifficulty[j]);
            res=Math.min(res,dailyMaxJobDiff+minDiff(j+1,n,d-1,jobDifficulty,mem));
        }
    
         mem[i][d] = res;
        return res;                 
        
    }
                         
}