class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice1=Integer.MAX_VALUE,profit1=0,minPrice2=Integer.MAX_VALUE,profit2=0;
        
        for(int i=0;i<prices.length;i++)
        {
            
            minPrice1=Math.min(minPrice1,prices[i]);
            profit1=Math.max(profit1,prices[i]-minPrice1);
            minPrice2=Math.min(minPrice2,prices[i]-profit1);
            profit2=Math.max(profit2,prices[i]-minPrice2);
            
        }
        
        return profit2;
        
    }
}