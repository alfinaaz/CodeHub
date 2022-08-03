/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map= new HashMap<>();
    int freq=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        if(root==null)
            return new int[0];
        
        ArrayList<Integer> list= new ArrayList<>();
       
        helper(root);
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue()>freq)
                freq=entry.getValue();
        }
         for(Map.Entry<Integer,Integer> entry : map.entrySet())
         {
             if(entry.getValue()==freq)
                 list.add(entry.getKey());
         }
         int[] arr= new int[list.size()];
        
      for(int i=0;i<list.size();i++)
      {
          arr[i]=list.get(i);
      }
           
        
        return arr;
        
    }
    
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        
        
       int l=helper(root.left);
       int r= helper(root.right);
        
        int sum=root.val+l+r;
        if(!map.containsKey(sum))
            map.put(sum,1);
        else
            map.put(sum,map.get(sum)+1);
        
        
        return sum;
        
        
    }
}