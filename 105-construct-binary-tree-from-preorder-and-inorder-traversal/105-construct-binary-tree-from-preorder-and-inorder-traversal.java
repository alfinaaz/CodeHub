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
    int[] preorder;
    int[] inorder;
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder=preorder;
        this.inorder=inorder;
        return helper(0,inorder.length-1);
        
        
    }
    public TreeNode helper(int si, int ei) {
                     
          
    
        
        if(si>ei)
            return null;
        
        int rootidx=-1;
        int rootele= preorder[idx];
        TreeNode root = new TreeNode(rootele);
         idx++;

      //  if(si==ei)
     //       return root;
        
        
        
        for(int i=si;i<=ei;i++)
        {
            if(inorder[i]==rootele)
                rootidx=i;
        }
        root.left= helper(si,rootidx-1);
        root.right= helper(rootidx+1,ei);
        
        
        return root;
        
    
}
}