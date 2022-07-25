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
    int d1=Integer.MAX_VALUE,d2=Integer.MIN_VALUE;
    public boolean isCousins(TreeNode root, int x, int y) {
        
         return helper(root,x,y,0);
        
    }
    public boolean helper(TreeNode root, int x,int y, int d)
    {
        if(root==null)
            return false;
        
            if(root.left!=null && root.right!=null){
        if((root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x))
                return false;
            }
        
        if(root.val==x)
            d1=d;
        
        else if(root.val==y)
            d2=d;
        
        if(d1==d2)
            return true;
        
    
       
        boolean b1= helper(root.left,x,y,d+1);
        boolean b2= helper(root.right,x,y,d+1);
        
        if(b1==true || b2==true)
            return true;
        
        
        return false;
    }
}