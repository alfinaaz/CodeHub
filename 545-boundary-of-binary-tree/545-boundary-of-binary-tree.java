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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        ans.add(root.val);
        leftHelper(root.left,ans);
        leaf(root.left,ans);
        leaf(root.right,ans);
        rightHelper(root.right,ans);
        return ans;
        
    }
     public void leftHelper(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        ans.add(root.val);
        if(root.left!=null) leftHelper(root.left,ans);
        else leftHelper(root.right,ans);
    }
    
    public void leaf(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            ans.add(root.val);
            return;
        }
        leaf(root.left,ans);
        leaf(root.right,ans);
    }
    
    
    public void rightHelper(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.right!=null) rightHelper(root.right,ans);
        else rightHelper(root.left,ans);
        ans.add(root.val);
    }
    
    
    
}