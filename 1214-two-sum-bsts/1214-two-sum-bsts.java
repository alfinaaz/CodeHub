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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        if(root1==null && root2==null)
            return false;
        
        if(root1==null || root2==null)
                return false;
        
        int k1= root1.val;
        if(search(root2,target-k1))
            return true;
        
     boolean x=   twoSumBSTs(root1.left,root2,target);
        if(x==true)
            return true;
     boolean y  =twoSumBSTs(root1.right,root2,target);
        if(y==true)
            return true;
        
        
        return false;
        
    }
    
    public boolean search(TreeNode root,int k)
    {
        if(root==null)
            return false;
        
        if(root.val==k)
            return true;
        
        if(k<root.val)
        {
          boolean x =search(root.left,k);
          if(x)
              return true;
        }
        
        else if(k>root.val)
        {
             boolean x =search(root.right,k);
          if(x)
              return true;
        }
        
        return false;
    }
}