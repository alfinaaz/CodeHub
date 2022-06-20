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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n= preorder.length;
        if(n==0)
            return null;
        
        
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> st= new Stack<>();
        st.push(root);
      
        for(int i=1;i<n;i++)
        {
            
            TreeNode node= st.peek();
            TreeNode child= new TreeNode(preorder[i]);
            
            if(child.val<=node.val)
                node.left=child;
            
            else if(child.val>node.val)
            {
                while(!st.isEmpty() && st.peek().val<=child.val)
                    node=st.pop();
                
                node.right=child;
            }
            st.push(child);
        }
        
        return root;
        
    }
}