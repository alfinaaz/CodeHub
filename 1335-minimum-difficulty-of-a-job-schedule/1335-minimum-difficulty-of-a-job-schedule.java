class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n=jobDifficulty.length;
        if(n<d)
            return -1;
        
        int[][] mem= new int[n+1][d+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<d+1;j++)
            {
                mem[i][j]=-1;
            }
        }
        
        return minDiff(0,n,d,jobDifficulty,mem);
         
    }
    public int minDiff(int i,int n,int d, int[] jobDifficulty,int[][] mem)
    {
        
        if(mem[i][d]!=-1)
            return mem[i][d];
        
        if(d==1)
        {
            int res=Integer.MIN_VALUE;
            for(int j=i;j<n;j++)
            {
                res= Math.max(res,jobDifficulty[j]);
            }
            
            return res;
        }
        
        int res= Integer.MAX_VALUE;
        
        
        int maxDiff=0;
        for(int j=i;j<n-(d-1);j++)
        {
            maxDiff=Math.max(maxDiff,jobDifficulty[j]);
            res=Math.min(res,maxDiff+minDiff(j+1,n,d-1,jobDifficulty,mem));
            
          
        }
        mem[i][d]=res;
        
       
        return res;
        
        
        
    }
}