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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list= new ArrayList<>();
       
        if(root==null)
            return list;
        
       StringBuilder s= new StringBuilder();
        helper(root,list,s);
     
        return list ;
        
    }
    
    public void helper(TreeNode root,List<String> list,StringBuilder str)
    {
        
        if(root==null)
        {
            return;
        }
         
        str.append(root.val);
     
        if(root.left==null && root.right==null)
        {
           //  str+=root.val;
             list.add(str.toString());
             //str = str.substring(0, str.length() - 1);
             return;
            
        }
        
       str.append("->");
         String save = str.toString();
        helper(root.left,list,str);
        helper(root.right,list,new StringBuilder(save));
        
         
        
        
        
    }
}