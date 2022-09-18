class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int zerocount=0,maxcount=0;
        int ws=0;
        
        for(int i=0;i<nums.length;i++)
        {
            
            if(nums[i]==0)
                zerocount++;
            
            while(zerocount>k)
            {
                if(nums[ws]==0)
                {
                    zerocount--;
                    ws++;
                }
                
                else
                    ws++;
            }
            
            maxcount=Math.max(maxcount,i-ws+1);
        }
        
        return maxcount;
        
    }
}