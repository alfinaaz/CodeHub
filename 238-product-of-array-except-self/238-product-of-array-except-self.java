class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n=nums.length;
        int lprod=1,rprod=1;
        int[] ans= new int[nums.length];
        int[] leftprod= new int[nums.length];
        int[] rightprod= new int[nums.length];
        
        leftprod[0]=1;
        rightprod[n-1]=1;
        
        for(int i=1;i<n;i++)
        {
            lprod= lprod*nums[i-1];
            leftprod[i]=lprod;
        }
        for(int i=n-2;i>=0;i--)
        {
            rprod=rprod*nums[i+1];
            rightprod[i]=rprod;
        }
        
        for(int i=0;i<n;i++)
        {
            ans[i]=leftprod[i]*rightprod[i];
        }
        
        return ans;
    }
}