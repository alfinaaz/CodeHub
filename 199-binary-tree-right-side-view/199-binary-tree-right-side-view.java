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
    public List<Integer> rightSideView(TreeNode root) {        
    List<Integer> arr= new ArrayList<>();
         
        if(root==null)
        {
            arr= new ArrayList<>();
            return arr;
        }
        
        TreeNode front=null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode E = new TreeNode();
        q.add(root);
        q.add(E);
        while(!q.isEmpty())
        {
            
                 front = q.remove();
                 

            
                if(front.left!=null)
                    q.add(front.left);
                
                if(front.right!=null)
                    q.add(front.right);
                
                if(q.peek()==E)
                {
                    q.poll();
                    q.add(E);
                    arr.add(front.val);
                }
                  
                
                 
            
            
        }
         
        return arr;
        
    }
}