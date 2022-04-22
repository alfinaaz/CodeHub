
//TWO TRAVERSALS AND NOT AN OPTIMSED SOLUTION
/*import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans= new int[2];
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],i);
        }
        
        for(Integer i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                if(i!=map.get(target-nums[i]))
                {
                    ans[0]=i;
                    ans[1]=map.get(target-nums[i]);
                    break;
                }
                    
            }
        }
        return ans;
}
}*/



// MORE OPTIMISED SOLUTION
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