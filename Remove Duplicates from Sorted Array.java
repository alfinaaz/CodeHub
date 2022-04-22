// for Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                
                nums[++k]=nums[i];
            }
        }
        
        return k+1;
    }
}
// for Sorted as well as unsorted

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[k])
            {
                
                nums[++k]=nums[i];
            }
        }
        
        return k+1;
    }
}