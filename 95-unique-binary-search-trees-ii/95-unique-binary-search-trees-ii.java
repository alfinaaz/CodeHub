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
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1,n);
        
        
    }
    public List<TreeNode> helper(int si, int ei)
    {
        List<TreeNode> ans= new ArrayList<>();
        if(si>ei)
        {
            List<TreeNode> temp= new ArrayList<>();
            temp.add(null);
            return temp;
        }
        for(int i=si;i<=ei;i++)
        {
            List<TreeNode> l= helper(si,i-1);
            List<TreeNode> r= helper(i+1,ei);
            
            
            for(TreeNode lnode : l)
            {
                for(TreeNode rnode:r)
                {
                    
                    TreeNode root= new TreeNode(i);
                    root.left=lnode;
                    root.right=rnode;
                    ans.add(root);
                    
                }
            }
            
            
            
        }
        return ans;
        
        
    }
}