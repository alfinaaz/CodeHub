https://leetcode.com/problems/3sum/


import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans= new int[2];
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],i);
            }
        }
        
        
        return ans;     
}
}