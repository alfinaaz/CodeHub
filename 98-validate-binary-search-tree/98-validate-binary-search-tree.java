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
 public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        BSTPair ans=BST(root);
        return ans.isBST;
    }
     public static class BSTPair{
      long max;
      long min;
      boolean isBST;
      
      BSTPair(){
          
      }
      BSTPair(long max,long min,boolean isBST){
          this.max=max;
          this.min=min;
          this.isBST=isBST;
      }
      
  }
  public static BSTPair BST(TreeNode node){
      if(node==null){
          return new BSTPair(Long.MIN_VALUE,Long.MAX_VALUE,true);
      }
      
      BSTPair lres=BST(node.left);
      BSTPair rres=BST(node.right);
      
      long mymax=Math.max(node.val,Math.max(lres.max,rres.max));
      long mymin=Math.min(node.val,Math.min(lres.min,rres.min));
      
      boolean ismyBST=false;
      if(lres.isBST==true && rres.isBST==true && lres.max<node.val && node.val<rres.min){
          ismyBST=true;
      }
      
      
      return new BSTPair(mymax,mymin,ismyBST);
  }
}