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

class Pair<T,V>{
    
    T first;
    V second;
    
    public Pair(T first,V second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
       
        Pair<Integer,Integer> ans= helper(root);
        
        return Math.max(ans.first,ans.second);
        
        
      
    }
    
    public Pair<Integer,Integer> helper(TreeNode root)
    {
        if(root==null)
            return new Pair<Integer,Integer>(0,0);
        
        
        Pair<Integer,Integer> p1=helper(root.left);
        Pair<Integer,Integer> p2= helper(root.right);
        
        int inc =root.val+p1.second+p2.second;
        
        int exc= Math.max(p1.first,p1.second)+Math.max(p2.first,p2.second);
        
        return new Pair<Integer,Integer>(inc,exc);
        
        
        
    }
}