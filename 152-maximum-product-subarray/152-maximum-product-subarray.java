class Solution {
    public int maxProduct(int[] arr) {
        
        int flag=0;
        
        if(arr.length==1)
            return arr[0];
        
        int maxEnd=1,minEnd=1,max=Integer.MIN_VALUE;
        
        for(int i=1;i<arr.length;i++)
        {
            
           if(!((arr[i]<0 && arr[i-1]==0)|| (arr[i]==0 && arr[i-1]<0)) || arr[i]==0 && arr[i-1]==0)
           {
               flag=1;
               break;
           }
            
            
        }
        if(flag==0)
            return 0;
        
        
      
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                maxEnd=1;
                minEnd=1;
                continue;
            }
            
            int temp=maxEnd;
            maxEnd=Math.max(Math.max(maxEnd*arr[i],minEnd*arr[i]),arr[i]);
            minEnd=Math.min(Math.min(temp*arr[i],minEnd*arr[i]),arr[i]);
            
            max=Math.max(max,maxEnd);
        }
        
        return max;
        
    }
}