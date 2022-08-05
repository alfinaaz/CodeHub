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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
         int l=0,r=0;
        if(root==null)
            return 0;
        
        
        if(high<root.val)
        {
           int sum1 =rangeSumBST(root.left,low,high);
            return sum1;
        }
         else if(low>root.val)
        {
            int sum2 =rangeSumBST(root.right,low,high);
             return sum2;
        }
        
       
        else// if(root.val>=low && root.val<=high)
        {
           
             l=  rangeSumBST(root.left,low,high);
             r=  rangeSumBST(root.right,low,high);
            
          
        }
        
        
          return root.val+l+r;
      
        
        
        
        
    }
}