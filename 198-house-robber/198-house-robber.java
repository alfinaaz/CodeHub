class Solution {
    public int rob(int[] nums) {
        
        int[] mem= new int[nums.length+1];
        Arrays.fill(mem,-1);
        return rob(0,nums.length-1,nums,mem);
     
    }
    
    public int rob(int si,int ei,int[] nums,int[] mem)
    {
        
        
        if(si>ei)
            return 0;
        
        if(mem[si]!=-1)
            return mem[si];
        
        
        int max=Integer.MIN_VALUE;
        
        int ans1=rob(si+1,ei,nums,mem);
        int ans2= nums[si]+rob(si+2,ei,nums,mem);
        
        max= Math.max(ans1,ans2);
        
        mem[si]=max;
        return max;
        
    }
}