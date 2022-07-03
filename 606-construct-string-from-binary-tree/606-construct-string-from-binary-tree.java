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
    public String tree2str(TreeNode root) {
        
        if(root==null)
            return "";
        
        String l = tree2str(root.left);
        String r = tree2str(root.right);
        
        if(l=="" && r=="")
            return String.valueOf(root.val);
        
        
          else if(l!=""&& r=="")
        return root.val+"("+l+")";
        
        else 
            return root.val+"("+l+")"+"("+r+")";
            
        
    }
}