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
    int count=0;
    HashMap<Integer,Integer> map= new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
         helper(0,root,targetSum);
        return count;
    }
    public  void helper(int curr_sum,TreeNode root,int k)
    {
        if(root==null)
                return;
        
        if((curr_sum+root.val)==k)
            count++;
        
        count+= map.getOrDefault((curr_sum+root.val-k),0);
        map.put(curr_sum+root.val,map.getOrDefault((curr_sum+root.val),0)+1);
        
       helper((curr_sum+root.val),root.left,k);
       helper((curr_sum+root.val),root.right,k);
        
         map.put((curr_sum+root.val), map.get(curr_sum+root.val) - 1);
    }
}