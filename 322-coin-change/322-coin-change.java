class Solution {
    Integer[] mem;
    public int coinChange(int[] coins, int amount) {
        
        mem= new Integer[amount+1];
        return helper(coins,amount);
        
    }
    
    private int helper(int[] coins, int remain)
    {
        if(remain<0)
            return -1;
        
        if(remain==0)
            return 0;
        
        if(mem[remain]!=null)
            return mem[remain];
        
        
        int minCount=Integer.MAX_VALUE;
        for(int coin : coins)
        {
            int count= helper(coins, remain-coin);
            if(count==-1)
                continue;
            
            minCount= Math.min(minCount,count+1);
            
        }
        
        mem[remain]= minCount==Integer.MAX_VALUE?-1:minCount;
        
        return mem[remain];
        
        
        
        
    }
}