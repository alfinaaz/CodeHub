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
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
            return root;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode front= q.remove();
            TreeNode temp=front.left;
            front.left=front.right;
            front.right=temp;
            
            if(front.left!=null)
                q.add(front.left);
            
            if(front.right!=null)
                q.add(front.right);
        }
        
        return root;
    }
}