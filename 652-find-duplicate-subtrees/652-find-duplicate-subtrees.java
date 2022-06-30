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
    static HashMap<String, Integer> m;
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        ans= new ArrayList<>();
        if(root==null)
             return ans;
        
        
        m= new HashMap<>();
           helper(root,ans,m);
            return ans;
    }
    public String helper(TreeNode root,List<TreeNode> ans, HashMap<String,Integer> m) {
     
        if(root==null)
        {
            return "";
        }
        
         String str = "(";
        
        str += helper(root.left,ans,m);
        str += Integer.toString(root.val);
        str += helper(root.right,ans,m);
         str += ")";
        
        
         if (m.get(str) != null && m.get(str)==1 )
            ans.add(root);
      
        if (m.containsKey(str))
            m.put(str, m.get(str) + 1);
        else
            m.put(str, 1);
         
        
        return str;
    }      
}