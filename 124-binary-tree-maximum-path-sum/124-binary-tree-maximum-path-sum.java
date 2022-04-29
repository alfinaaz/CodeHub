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
     int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
       int temp=maxPathSum1(root);
        return res;
        
    }
    
     public int maxPathSum1(TreeNode root) {
    
     if(root==null)
            return 0;
        
        int l= maxPathSum1(root.left);
        int r= maxPathSum1(root.right);
        
        int temp=Math.max((int)Math.max(l,r)+root.val,root.val);
        int ans=Math.max(temp,(l+r+root.val));
        res=Math.max(res,ans);
        
        return temp;
}
}