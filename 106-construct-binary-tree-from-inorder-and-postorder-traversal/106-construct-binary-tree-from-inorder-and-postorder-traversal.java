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
    int[] inorder;
    int[] postorder;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.inorder=inorder;
        this.postorder=postorder;
        this.idx=this.postorder.length-1;
        
        return helper(0,inorder.length-1);
        
    }
    public TreeNode helper(int si, int ei)
    {
        
        
        if(si>ei)
            return null;
        
        int rootidx=-1;
        int ele=postorder[idx];
        TreeNode root= new TreeNode(ele);
      
        for(int i=si;i<=ei;i++)
        {
            if(inorder[i]==ele)
            {
                rootidx=i;
                //break;
            }
                
        }
        idx--;
         root.right=helper(rootidx+1,ei);
        root.left=helper(si,rootidx-1);
       
        
        return root;
        
    }
    
    
}