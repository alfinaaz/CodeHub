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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
          int temp1=diameter1(root);
        // returning the result.
        return res-1;
    }
     public int diameter1(TreeNode root) {
        // if node becomes null, we return 0.
        if (root == null) return 0;

        // calling the util function recursively for the left and
        // right subtrees to find their heights.
        int l = diameter1(root.left);
        int r = diameter1(root.right);

        // storing the maximum possible value of l+r+1 in diameter.
        int temp=1 + Math.max(l, r);
        int ans =Math.max(temp,l+r+1);
        res=Math.max(res,ans);
        // returning height of subtree.
        return temp;
    }
}