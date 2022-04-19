class Solution {
    public int longestConsecutive(int[] arr) {
        
        int n= arr.length;
        int max=0;
        HashSet<Integer> map= new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            map.add(arr[i]);
        }
        
        for(int i=0;i<arr.length;i++)
        {
            if(!map.contains(arr[i]-1))
            {
                
                int j=arr[i];
                while(map.contains(j))
                    j++;
                
                max= Math.max(max,j-arr[i]);
                
                
            }
            
            
        }
        
        return max;
        
    }
}