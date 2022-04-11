class Solution {
    public int findDuplicate(int[] arr) {
        
        int ans=0,n=arr.length;
        for(int i=0;i<arr.length;i++)
        {
            arr[(arr[i]-1)%n]= arr[(arr[i]-1)%n]+n;
        }
         for(int i=0;i<arr.length;i++)
        {
           arr[i]=arr[i]/n;
            if(arr[i]>1)
                ans=i+1;
        }
        
        return ans;
    }
}