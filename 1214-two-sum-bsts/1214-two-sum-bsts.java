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
     public Set<Integer> inHashset(TreeNode r, int target, Set<Integer> s) {
    if (r == null) return s;
         
    s.add(target - r.val);
    inHashset(r.left, target, s);
    inHashset(r.right, target, s);
    return s;
  }

  public boolean inCheck(TreeNode r, Set<Integer> s) {
    if (r == null) return false;
     
      if(s.contains(r.val))
          return true;
    boolean x= inCheck(r.left, s);
        if(x)
            return true;
      
    boolean y= inCheck(r.right, s);
      if(y)
          return true;
      
      return false;
  }

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Set<Integer> s = inHashset(root1, target, new HashSet());
    return inCheck(root2, s);
  }
}