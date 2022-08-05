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
    ArrayDeque<TreeNode> stack = new ArrayDeque();
    Set<Integer> s = new HashSet();
    // traverse the first tree 
    // and store node complements (target - val) in hashset
    while (!stack.isEmpty() || root1 != null) {
      while (root1 != null) {
        stack.push(root1);
        root1 = root1.left;
      }
      root1 = stack.pop();
      s.add(target - root1.val);
      root1 = root1.right;
    }

    // traverse the second tree 
    // and check if one of the values exists in hashset
    while (!stack.isEmpty() || root2 != null) {
      while (root2 != null) {
        stack.push(root2);
        root2 = root2.left;
      }
      root2 = stack.pop();
      if (s.contains(root2.val)) {
        return true;
      }
      root2 = root2.right;
    }
    
    return false;
  }
}