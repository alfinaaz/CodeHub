class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int windowstart=0;
        int minwindow=Integer.MAX_VALUE;
        int currentwindowsum=0;
        
        for(int i=0;i<nums.length;i++)
        {
             currentwindowsum+=nums[i];
            
            
            while(currentwindowsum>=target)
            {
                
                minwindow= Math.min(minwindow,i-windowstart+1);
                // can we do better by shrinking the window
                currentwindowsum-=nums[windowstart];
                windowstart++;
                
                
            }
            
        }
        
        
        return minwindow==Integer.MAX_VALUE?0:minwindow;
        
        
        
        
    }
}