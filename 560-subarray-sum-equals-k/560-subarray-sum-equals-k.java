class Solution {
    public int subarraySum(int[] nums, int k) {
         int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();
        
        for(int num : nums){
        
            currSum+=num;
        
        
        if(currSum==k)
            count++;
        
        count+=h.getOrDefault(currSum-k,0);
        h.put(currSum,h.getOrDefault(currSum,0)+1);
        
        
        }
        return count;
        
        
    }
}