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
    int total=0;
    public int sumRootToLeaf(TreeNode root) {
        
        helper(root,0);
        return total;
        
    }
    public void helper(TreeNode root,int curr)
    {
        
        
        if(root==null)
        {
            return;
        }
        
          if(root.left==null && root.right==null)
        {
            curr= (curr<<1) |root.val;
            total+=curr;
             return;
        }
      
        curr= (curr<<1) |root.val;
        helper(root.left,curr);
        helper(root.right,curr);
        
        
    }
        
    }