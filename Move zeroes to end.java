https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length,count=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                swap(i,count,nums);
                count++;
                
            }
            
        }
    }
    public void swap(int i, int count, int[] arr)
    {
        int temp=arr[i];
        arr[i]=arr[count];
        arr[count]=temp;
    }
}