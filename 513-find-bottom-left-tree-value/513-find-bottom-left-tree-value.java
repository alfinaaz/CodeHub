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
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> tree = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int level=q.size();
            ArrayList<TreeNode> l= new ArrayList<>();
            while(level>0)
            {
               
                TreeNode front= q.remove();
                l.add(front);
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
                
                
                level--;
            }
            tree.add(l);
        }
        
        return tree.get(tree.size()-1).get(0).val;
        
    }
}