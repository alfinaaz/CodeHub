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
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr=root;
        ArrayList<Integer> arr = new ArrayList<>();
        while(curr!=null)
        {
            if(curr.left==null)
            {
                arr.add(curr.val);
                curr=curr.right;
            }
            else
            {
                
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr)
                {
                    temp=temp.right;
                }
                if(temp.right==null)
                {
                    temp.right=curr;
                    curr=curr.left;
                }
                if(temp.right==curr)
                {
                    temp.right=null;
                    arr.add(curr.val);
                    curr=curr.right;
                }
                
                
                
                
            }
            
            
            
            
        }
        return arr.get(k-1);
        
    }
}