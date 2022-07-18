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
        
         List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
       
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> level_list =  new LinkedList<>();
        boolean isLeft=true;
        q.add(root);
        q.add(null);
        
        while(q.size()>0)
        {
            TreeNode node= q.pollFirst();
            if(node!=null)
            {
                if(isLeft)
                {
                    
                    level_list.addLast(node.val);           
                }
                else
                {
                    level_list.addFirst(node.val);     
                }
                
                if(node.left!=null)
                    q.addLast(node.left);
                
                if(node.right!=null)
                    q.addLast(node.right);
            }
            else
            {
                res.add(level_list);
                 level_list = new LinkedList<Integer>();
                 if (q.size() > 0)
                    q.addLast(null);
                isLeft = !isLeft;
            }
        }
        return res;
        
    }
}