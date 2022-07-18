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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
          if (root == null) {
      return new ArrayList<List<Integer>>();
    }
        
         List<List<Integer>> res= new ArrayList<>();
         helper(root,0,res);
        
        return res;
        
    }
    public void helper(TreeNode root,int level,List<List<Integer>> res)
    {
        if(level>=res.size())
        {
            LinkedList<Integer> level_list = new LinkedList<>();
            level_list.add(root.val);
            res.add(level_list);
        }
        else
        {
            if(level%2==0)
                res.get(level).add(root.val);
            
            else
                res.get(level).add(0,root.val);
        }   
            if(root.left!=null)
                helper(root.left,level+1,res);
            if(root.right!=null)
                helper(root.right,level+1,res);
                
        
    }
}