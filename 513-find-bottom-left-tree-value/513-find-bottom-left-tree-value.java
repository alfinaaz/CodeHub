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
    int ans=0,h=0;
    public int findBottomLeftValue(TreeNode root) {
        
       
        
        helper(root,1);
        return ans;
    }
    
    public void helper(TreeNode root,int depth)
    {
        
        if(h<depth)
        {
            h=depth;
            ans=root.val;
        }
        if(root.left!=null) helper(root.left,depth+1);
        if(root.right!=null)helper(root.right,depth+1);
    }
}