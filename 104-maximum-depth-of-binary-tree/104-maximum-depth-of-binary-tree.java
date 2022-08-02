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
    int h=0;
    public int maxDepth(TreeNode root) {
        
             helper(root,1);
             return h;
        
    }
    public void helper(TreeNode root,int d)
    {
        
        if(root==null)
            return;
        
        h=Math.max(h,d);
        
        helper(root.left,d+1);
        helper(root.right,d+1);
        
        
    }
}