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
        
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while(true)
        {
            if(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            else
            {
                if(st.isEmpty())
                    break;
                root=st.pop();
                arr.add(root.val);
                root=root.right;
            }
            
        }
        
        return arr.get(k-1);
        
    }
}