class Solution {
    public int getMaxLen(int[] nums) {
        
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;)
        {
            
            int si=i;
            while(si<n && nums[si]==0)si++;
            int ei=si;
            int sn=-1;
            int en=-1;
            int count=0;
            while(ei<n && nums[ei]!=0)
            {
                
                if(nums[ei]<0)
                {
                    count++;
                    if(sn==-1)sn=ei;
                    en=ei;
                }
                
                ei++;
            }
            if(count%2==0)
            ans= Math.max(ans,ei-si);
            
            if(sn!=-1)
            ans=Math.max(ans,ei-(sn+1));
            
            if(en!=-1)
                ans=Math.max(ans,en-si);
            
            
            i=ei+1;
            
        }
        
        return ans;
    }
}