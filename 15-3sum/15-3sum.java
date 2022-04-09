class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 || nums[i]!=nums[i-1])
            {
                
                int low=i+1;
                int high=nums.length-1;
                int target=0-nums[i];
                
                while(low<high)
                {
                    if(nums[low]+nums[high]==target)
                    {
                        res.add(Arrays.asList(nums[low],nums[high],nums[i]));
                        
                        
                        while(low<high && nums[low]==nums[low+1])
                                low++;
            
                        low++;
                        high--;
                        
                    }
                    
                    else if(nums[low]+nums[high]<target)
                         low++;
                    
                    
                    else
                        high--;
                    
                    
                    
                }
                
                
            }
        }
        return res;
        
    }
}