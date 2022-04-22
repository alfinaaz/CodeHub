https://leetcode.com/problems/squares-of-a-sorted-array/

/*
class Solution {
    public int[] sortedSquares(int[] nums) {
         
        int[] arr= new int[nums.length];
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
                count++;
        }
        int k=0,i=0,j=0;
        if(count!=0){
        i=count-1;
        j=count;
        while(i>=0 && j<nums.length){
        if(Math.abs(nums[i])<nums[j])
        {
            arr[k]=(int)Math.pow(nums[i],2);
            i--;
            k++;
            
        }
        
       else if(Math.abs(nums[i])>nums[j])
        {
            arr[k]=(int)Math.pow(nums[j],2);
            j++;
            k++;
            
        }      
       else
       {
           arr[k]=(int)Math.pow(nums[j],2);
               k++;
           arr[k]=(int)Math.pow(nums[j],2);
               k++;
           
           i--;
           j++;
       }   
            
        }
      while(j<nums.length)
     {
         arr[k]=(int)Math.pow(nums[j],2);
         j++;
         k++;
     }
    
      while(i>=0)
     {
         arr[k]=(int)Math.pow(nums[i],2);
         k++;
         i--;
     }
            
            
        }
        
        else
        {
            for( i=0;i<nums.length;i++)
            {
                arr[k]=(int)Math.pow(nums[i],2);
                    k++;
            }
        }
        
        return arr;
    }
}*/

// More Optimised Solution
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int lo=0,high=nums.length-1;
        for(int k=nums.length-1;k>=0;k--)
        {
            if(Math.abs(nums[lo])>=Math.abs(nums[high]))
            {
                arr[k]=nums[lo]*nums[lo];
                lo++;
            }
           else  if(Math.abs(nums[lo])<Math.abs(nums[high]))
            {
                arr[k]=nums[high]*nums[high];
                high--;
            }
            
        }
        
        return arr;
        
    }
}