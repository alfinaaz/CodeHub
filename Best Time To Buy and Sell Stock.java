https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


/*class Solution {
    public int maxProfit(int[] prices) {
    
        int n=prices.length;
        int[] rightMax= new int[n];
        int[] sales=new int[n];
        rightMax[n-1]=prices[n-1]; //-------> we can also take out the left min;
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(prices[i],rightMax[i+1]);
        }
        
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sales[i]=rightMax[i]-prices[i]; //---------> then it would be sales[i]=prices[i]-leftMin[i];
            max=Math.max(max,sales[i]);
        }
        
        return max;
    }
}
*/
//More optimised solution. left min can be calculated in a smarter way in one loop only.
class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE,sell=0;
        for(int i=0;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            sell=Math.max(sell,prices[i]-buy);
        }
       return sell;
    }
}
