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
   // String str2="";
    
    boolean flag=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String str1= serialize(subRoot,"");
        helper(root,str1);
        
        if(flag==true)
            return true;
        
        return false;
    }
    public String helper(TreeNode root,String str1)
    {
         if(root==null)
         {
             return "N,";
         }
      // str2+=String.valueOf(root.val)+"," ;
      // str2+= helper(root.left,str1);
      // str2+= helper(root.right,str1);
        
        String l= helper(root.left,str1);
        String r= helper(root.right,str1);
        
        String str2 =root.val+","+l+r;
        
        if(str2.equals(str1))
        {
            flag=true;
           
        }
        
        return str2;
        
    }
    
    public String serialize(TreeNode root,String str1)
    {
        if(root==null)
        {
            str1+="N,";
            return str1;

        }
        str1+=(root.val)+",";
        str1=serialize(root.left,str1);
        str1=serialize(root.right,str1);
        
        return str1;
    }
}