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
        String s="";
        helper(root,list,s);
        return list;
        
    }
    
    public void helper(TreeNode root,List<String> list,String str)
    {
        
        if(root==null)
        {
            return;
        }
         
        str+=root.val;
     
        if(root.left==null && root.right==null)
        {
           //  str+=root.val;
             list.add(str);
             //str = str.substring(0, str.length() - 1);
             return;
            
        }
        
        str+="->";
        helper(root.left,list,str);
        helper(root.right,list,str);
        
          str = str.substring(0, str.length() - 1);
          str = str.substring(0, str.length() - 1);
        
        
        
    }
}