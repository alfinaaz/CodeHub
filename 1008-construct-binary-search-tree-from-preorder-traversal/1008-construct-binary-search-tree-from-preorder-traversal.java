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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
         int n=preorder.length;
         int high= Integer.MAX_VALUE;
         int low= Integer.MIN_VALUE;
         return helper(low,high,preorder,n);
        
    }
    public TreeNode helper(int low, int high, int[] preorder,int n) {
        
        if(idx==n)
            return null;
        
          int val = preorder[idx];
           if (val < low || val > high) return null;

           idx++;
        
    TreeNode root = new TreeNode(val);
    root.left = helper(low, val,preorder,n);
    root.right = helper(val, high,preorder,n);
    return root;
}
}