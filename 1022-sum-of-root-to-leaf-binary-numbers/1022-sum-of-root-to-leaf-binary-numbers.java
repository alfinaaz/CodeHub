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
    public int sumRootToLeaf(TreeNode root) {
        
        helper(root,"");
        return total;
        
    }
    public void helper(TreeNode root,String s)
    {
        
        
        if(root==null)
        {
            return;
        }
        
          if(root.left==null && root.right==null)
        {
            s+=root.val;
            calculate(s);
            return;
        }
      
        s+=root.val;
        helper(root.left,s);
        helper(root.right,s);
        
        
    }
      int total=0;
    public void calculate(String s)
    {
       int h=1; 
      for(int i=s.length()-1;i>=0;i--)
      {
          total+=((s.charAt(i)-'0')*h);
          h=h*2;
      }
            
        
        
    }
}