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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans= new LinkedList<>();
        
        if(root==null)
            return ans;
        LinkedList<TreeNode> q= new LinkedList<>();
        q.addLast(root);
        TreeNode E = new TreeNode();
        q.addLast(E);
        List<Integer> level= new ArrayList<>();
        while(!q.isEmpty())
        {
          
           TreeNode front=q.remove();
           level.add(front.val);
            
             if(front.left!=null)
               q.add(front.left);
            
             if(front.right!=null)
                q.add(front.right);
            
          
            
           
            
            if(q.peek()==E)
            {
                q.poll();
                ans.add(0,level);
                q.add(E);
                level=new ArrayList<>();
            }
            
            
            
            
        }
        return ans;
    }
}