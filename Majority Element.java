https://leetcode.com/problems/majority-element/


class Solution {
    public int majorityElement(int[] nums) {
        
        int count=1,res=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==res)
                count++;
            else
                count--;
            
            if(count==0)
            {
                count=1;
                res=nums[i];
            }
        }
         int count1=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==res)
            {
                count1++;
            }
            
            if(count1>(nums.length)/2)
                return res;
        }
        
        return -1;
    }
}